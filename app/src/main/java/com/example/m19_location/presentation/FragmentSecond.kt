package com.example.m19_location.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.m19_location.databinding.SecondFragmentBinding
import com.example.m19_location.entity.Gallery
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class FragmentSecond: Fragment() {

    private var _binding: SecondFragmentBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<FragmentSecondArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi(args.photos)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun updateUi(photo: Gallery) {
        val currentDate = LocalDate.now()
        binding.newcurrentDate.text = currentDate.toString()
        Glide
            .with(this)
            .load(photo.photo.replace("http", "https"))
            .into(binding.newphoto)
    }

}
