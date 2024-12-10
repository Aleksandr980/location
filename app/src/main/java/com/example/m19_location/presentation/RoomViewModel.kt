package com.example.m19_location.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m19_location.domain.GetGalleryUseCase
import com.example.m19_location.entity.Gallery
import com.yandex.mapkit.location.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
open class RoomViewModel @Inject constructor(private val getGalleryUseCase: GetGalleryUseCase) : ViewModel() {
   // private val _coordinats: MutableStateFlow<Location> = MutableStateFlow(Location())
    //val coordinats: StateFlow<Location> = _coordinats.asStateFlow()
    val allGallery = this.getGalleryUseCase.galleryRepository.galleryDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    suspend fun onAdd(gallery: Gallery) {
        getGalleryUseCase.onAdd(gallery)
    }

    suspend fun onUpdate(gallery: Gallery) {
        getGalleryUseCase.onUpdate(gallery)
    }

    suspend fun onDelete() {
        getGalleryUseCase.onDelete()
    }

    suspend fun onContainsPhoto(photo: String): List<Gallery> {
        return getGalleryUseCase.onContainsPhoto(photo)
    }
    suspend fun onContainsDate(date: String): List<Gallery> {
        return getGalleryUseCase.onContainsDate(date)
    }
}
