package com.example.m19_location.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.m19_location.databinding.FirstFragmentBinding
import com.example.m19_location.entity.Gallery
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FragmentFirst: Fragment() {
    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RoomViewModel by viewModels()
    private val myListAdapter = MyListAdapter { onItemClickPhoto(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FirstFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = myListAdapter
        viewModel.allGallery.onEach {
            myListAdapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    private fun onItemClickPhoto(item: Gallery) {
        val action: NavDirections =
            FragmentFirstDirections.actionFragmentFirstToFragmentSecond(item)

        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
