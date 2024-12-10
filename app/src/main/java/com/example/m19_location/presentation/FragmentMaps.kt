package com.example.m19_location.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.m19_location.R
import com.example.m19_location.databinding.MapsFragmentBinding
import com.example.m19_location.utils.Constants.Companion.MY_API_KEY
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class FragmentMaps : Fragment() {
    private lateinit var fusedClient: FusedLocationProviderClient
    private lateinit var mapView: MapView
    private var zoomLevel = 17.0f
    private val maxZoom = 23.0f
    private val minZoom = 0.0f
    private var _binding: MapsFragmentBinding? = null
    private val binding get() = _binding!!
    private var outPoint = Point()
    private val launcherMap: ActivityResultLauncher<Array<String>> = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { map ->
        if (map.values.isNotEmpty() && map.values.all { it }) {
            startLocation()
        }
    }
    private val placemarkTapListener = MapObjectTapListener { _, point ->
        Toast.makeText(
            requireContext(),
            "Координаты фиктивной локации (${point.longitude}, ${point.latitude})",
            Toast.LENGTH_SHORT
        ).show()
        true
    }
    private val placemarkTapListener1 = MapObjectTapListener { _, point ->
        Toast.makeText(
            requireContext(),
            "Государственный Эрмитаж (${point.longitude}, ${point.latitude})",
            Toast.LENGTH_SHORT
        ).show()
        true
    }
    private val placemarkTapListener2 = MapObjectTapListener { _, point ->
        Toast.makeText(
            requireContext(),
            "Дворцовая площадь (${point.longitude}, ${point.latitude})",
            Toast.LENGTH_SHORT
        ).show()
        true
    }

    // Установка колбека для обработки результатов запроса на определение местоположения
    private val locationListener = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            result.lastLocation?.let { location ->
                outPoint = Point(location.latitude, location.longitude)
            }
        }


    }

    //текущее местоположение
    fun currentLocation(point: Point) {
        mapView.map.move(
            CameraPosition(
                point, zoomLevel, 0.0f, 0.0f
            ), Animation(Animation.Type.SMOOTH, 5f), null
        )
    }

    //моя фиктивная локация
    fun myLocation(point: Point) {
        mapView.map.move(
            CameraPosition(
                point, zoomLevel, 0.0f, 0.0f
            ), Animation(Animation.Type.SMOOTH, 5f), null
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        MapKitFactory.setApiKey(MY_API_KEY)
        MapKitFactory.initialize(requireContext())
        fusedClient = LocationServices.getFusedLocationProviderClient(requireContext())
        _binding = MapsFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("MissingPermission")
    fun startLocation() {
        val request: LocationRequest =
            LocationRequest.create().setInterval(1_000).setPriority(Priority.PRIORITY_HIGH_ACCURACY)

        fusedClient.requestLocationUpdates(
            request, locationListener, Looper.getMainLooper()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//стартовый экран - дворцовая площадь
        mapView = binding.mapView
        mapView.map.move(
            CameraPosition(
                Point(59.939032, 30.315827), zoomLevel, 0.0f, 0.0f
            ), Animation(Animation.Type.SMOOTH, 5f), null
        )

        val mapKit: MapKit = MapKitFactory.getInstance()
        val probki = mapKit.createTrafficLayer(mapView.mapWindow)
        probki.isTrafficVisible = true
        // Фиктивная локация
        val imageProvider = ImageProvider.fromResource(requireContext(), R.drawable.my_location)
        val placemark = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.936936, 30.245826)
            setIcon(imageProvider)
        }
        //Государственный Эрмитаж
        val imageProvider1 = ImageProvider.fromResource(requireContext(), R.drawable.marker)
        val placemark1 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.939864, 30.314566)
            setIcon(imageProvider1)
        }
        //Дворцовая площадь
        val imageProvider2 = ImageProvider.fromResource(requireContext(), R.drawable.marker)
        val placemark2 = mapView.map.mapObjects.addPlacemark().apply {
            geometry = Point(59.939032, 30.315827)
            setIcon(imageProvider2)
        }


        placemark.addTapListener(placemarkTapListener)
        placemark1.addTapListener(placemarkTapListener1)
        placemark2.addTapListener(placemarkTapListener2)

        mapView.map.isRotateGesturesEnabled = false
        mapView.map.isZoomGesturesEnabled = true


        binding.buttonPlus.setOnClickListener {
            if (binding.buttonLocation.isPressed == true || myLocation(TARGET_LOCATION) == Unit) {
                onButtonPlusClick(TARGET_LOCATION)
            } else {
                onButtonPlusClickCurrentLocation()
            }
        }

        binding.buttonMinus.setOnClickListener {
            if (binding.buttonLocation.isPressed == true || myLocation(TARGET_LOCATION) == Unit) {
                onButtonMinusClick(TARGET_LOCATION)
            } else {
                onButtonMinusClickCurrentLocation()
            }
        }

        binding.buttonLocation.setOnClickListener {
            myLocation(TARGET_LOCATION)
        }
    }

    private fun checkPermissionsMap() {
        if (REQUEST_PERMISSIONSMAP.all { permission: String ->
                ContextCompat.checkSelfPermission(
                    requireContext(), permission
                ) == PackageManager.PERMISSION_GRANTED
            }) {
            startLocation()
        } else {
            launcherMap.launch(REQUEST_PERMISSIONSMAP)
        }
    }

    override fun onStart() {
        super.onStart()
        checkPermissionsMap()
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()
        fusedClient.removeLocationUpdates(locationListener)
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }

    fun onButtonPlusClick(point: Point) {

        if (zoomLevel < maxZoom) {
            zoomLevel++
            mapView.map.move(
                CameraPosition(
                    point, zoomLevel, 0.0f, 0.0f
                ), Animation(Animation.Type.SMOOTH, 5f), null
            )
        } else {
            Toast.makeText(
                requireContext(), "Максимальный уровень зума", Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun onButtonMinusClick(point: Point) {

        if (zoomLevel > minZoom) {
            zoomLevel--
            mapView.map.move(
                CameraPosition(
                    point, zoomLevel, 0.0f, 0.0f
                ), Animation(Animation.Type.SMOOTH, 5f), null
            )
        } else {
            Toast.makeText(requireContext(), "Минимальный уровень зума", Toast.LENGTH_SHORT).show()
        }
    }

    fun onButtonPlusClickCurrentLocation() {
        if (zoomLevel < maxZoom) {
            zoomLevel++
            currentLocation(outPoint)
        } else {
            Toast.makeText(
                requireContext(), "Максимальный уровень зума", Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun onButtonMinusClickCurrentLocation() {
        if (zoomLevel > minZoom) {
            zoomLevel--
            currentLocation(outPoint)
        } else {
            Toast.makeText(requireContext(), "Минимальный уровень зума", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private val REQUEST_PERMISSIONSMAP: Array<String> = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
        )

        private val TARGET_LOCATION = com.yandex.mapkit.geometry.Point(59.936936, 30.245826)

    }
}

