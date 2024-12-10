package com.example.m19_location.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.m19_location.databinding.ZeroFragmentBinding
import com.example.m19_location.entity.Gallery
import com.google.common.util.concurrent.ListenableFuture
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Locale
import java.util.concurrent.Executor


private const val FILENAME_FORMAT = "dd-MM-yyyy"

@AndroidEntryPoint
class FragmentZero : Fragment() {

    private var imageCapture: ImageCapture? = null
    private lateinit var executor: Executor
    private var _binding: ZeroFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RoomViewModel by viewModels()
    private val name: String = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
        .format(System.currentTimeMillis())

    private val launcher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            if (map.values.all { it }) {
                startCamera()
            } else {
                Toast.makeText(requireContext(), "permission is  not Granted", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ZeroFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        executor = ContextCompat.getMainExecutor(requireContext())
        binding.button.setOnClickListener {
            takePhoto()
        }
        checkPermissions()
        binding.buttonMap.setOnClickListener {
            val action: NavDirections =
                FragmentZeroDirections.actionFragmentZeroToFragmentMaps()
            findNavController().navigate(action)
        }

    }

    private fun takePhoto() {
        val imageCapture: ImageCapture = imageCapture ?: return

        val contentValues: ContentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }

        val outputOptions: ImageCapture.OutputFileOptions = ImageCapture.OutputFileOptions.Builder(
            requireActivity().contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        ).build()
        imageCapture.takePicture(
            outputOptions,
            executor,
            object : ImageCapture.OnImageSavedCallback {
                @SuppressLint("ResourceType", "SuspiciousIndentation")
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val uriStr = outputFileResults.savedUri.toString()
                    Toast.makeText(
                        requireContext(),
                        "Photo saved on: $uriStr",
                        Toast.LENGTH_SHORT
                    ).show()

                    Glide.with(requireContext())
                        .load(uriStr)
                        .circleCrop()
                        .into(binding.imagePreview)

                    viewModel.viewModelScope.launch {
                        val gallery = Gallery(uriStr, LocalDate.now().toString())
                        viewModel.onAdd(gallery)
                    }
                    val action: NavDirections =
                        FragmentZeroDirections.actionFragmentZeroToFragmentFirst()
                    findNavController().navigate(action)

                }

                override fun onError(exception: ImageCaptureException) {
                    Toast.makeText(
                        requireContext(),
                        "Photo failed: ${exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }

    private fun startCamera() {
        val cameraProviderFuture: ListenableFuture<ProcessCameraProvider> =
            ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview: Preview = Preview.Builder().build()
            preview.setSurfaceProvider(binding.viewFinder.surfaceProvider)
            imageCapture = ImageCapture.Builder().build()

            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                this,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                imageCapture
            )
        }, executor)
    }


    private fun checkPermissions() {
        val isAllGranted: Boolean = REQUEST_PERMISSIONS.all { permission: String ->
            ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED
        }
        if (isAllGranted) {
            startCamera()
            Toast.makeText(requireContext(), "permission is Granted", Toast.LENGTH_SHORT).show()
        } else {
            launcher.launch(REQUEST_PERMISSIONS)
        }
    }

    companion object {
        private val REQUEST_PERMISSIONS: Array<String> = buildList {
            add(Manifest.permission.CAMERA)
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }
}



/*
import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.m19_location.databinding.ZeroFragmentBinding
import com.example.m19_location.entity.Gallery
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.common.util.concurrent.ListenableFuture
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Locale
import java.util.concurrent.Executor

private const val FILENAME_FORMAT = "dd-MM-yyyy"

@AndroidEntryPoint
class FragmentZero : Fragment() {

    private var imageCapture: ImageCapture? = null
    private lateinit var executor: Executor
    private var fusedClient: FusedLocationProviderClient? = null
    private var _binding: ZeroFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RoomViewModel by viewModels()
    private val name: String = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
        .format(System.currentTimeMillis())
    private val launcherMap: ActivityResultLauncher<Array<String>> = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { map ->
        if (map.values.isNotEmpty() && map.values.all { it }) {
            startLocation()
        }
    }
    private val launcherCamera: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            if (map.values.all { it }) {
                startCamera()
            } else {
                Toast.makeText(requireContext(), "permission is  not Granted", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ZeroFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        executor = ContextCompat.getMainExecutor(requireContext())
        //MapKitFactory.setApiKey("8d3fc0e1-fedc-4db3-a90e-adf3de2d5646")
        binding.button.setOnClickListener {
            takePhoto()
        }
        checkPermissionsCamera()
        binding.buttonMap.setOnClickListener {
            val action: NavDirections =
                FragmentZeroDirections.actionFragmentZeroToFragmentMaps()
            findNavController().navigate(action)
        }
        checkPermissionsMap()

        fusedClient = LocationServices.getFusedLocationProviderClient(requireContext())
    }

    private fun takePhoto() {
        val imageCapture: ImageCapture = imageCapture ?: return

        val contentValues: ContentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }

        val outputOptions: ImageCapture.OutputFileOptions = ImageCapture.OutputFileOptions.Builder(
            requireActivity().contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        ).build()
        imageCapture.takePicture(
            outputOptions,
            executor,
            object : ImageCapture.OnImageSavedCallback {
                @SuppressLint("ResourceType", "SuspiciousIndentation")
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val uriStr = outputFileResults.savedUri.toString()
                    Toast.makeText(
                        requireContext(),
                        "Photo saved on: $uriStr",
                        Toast.LENGTH_SHORT
                    ).show()

                    Glide.with(requireContext())
                        .load(uriStr)
                        .circleCrop()
                        .into(binding.imagePreview)

                    viewModel.viewModelScope.launch {
                        val gallery = Gallery(uriStr, LocalDate.now().toString())
                        viewModel.onAdd(gallery)
                    }
                    val action: NavDirections =
                        FragmentZeroDirections.actionFragmentZeroToFragmentFirst()
                    findNavController().navigate(action)

                }

                override fun onError(exception: ImageCaptureException) {
                    Toast.makeText(
                        requireContext(),
                        "Photo failed: ${exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }

    private fun startCamera() {
        val cameraProviderFuture: ListenableFuture<ProcessCameraProvider> =
            ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview: Preview = Preview.Builder().build()
            preview.setSurfaceProvider(binding.viewFinder.surfaceProvider)
            imageCapture = ImageCapture.Builder().build()

            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                this,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                imageCapture
            )
        }, executor)
    }

    private fun checkPermissionsCamera() {
        val isAllGranted: Boolean = REQUEST_PERMISSIONSCAMERA.all { permission: String ->
            ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
        if (isAllGranted) {
            startCamera()
            Toast.makeText(requireContext(), "permission is Granted", Toast.LENGTH_SHORT).show()
        } else {
            launcherCamera.launch(REQUEST_PERMISSIONSCAMERA)
        }
    }


    val locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            result.lastLocation
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocation() {
        val request: LocationRequest = LocationRequest.create()
            .setInterval(1_000)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)

        fusedClient?.requestLocationUpdates(
            request,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    override fun onStart() {
        super.onStart()
        checkPermissionsMap()
    }

    override fun onStop() {
        super.onStop()
        fusedClient?.removeLocationUpdates(locationCallback)
    }

    private fun checkPermissionsMap() {
        if (REQUEST_PERMISSIONSMAP.all { permission: String ->
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    permission
                ) == PackageManager.PERMISSION_GRANTED
            }) {
            startLocation()
        } else {
            launcherMap.launch(REQUEST_PERMISSIONSMAP)
        }
    }

    companion object {
        private val REQUEST_PERMISSIONSCAMERA: Array<String> = buildList {
            add(Manifest.permission.CAMERA)
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()

        private val REQUEST_PERMISSIONSMAP: Array<String> = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}

 */
