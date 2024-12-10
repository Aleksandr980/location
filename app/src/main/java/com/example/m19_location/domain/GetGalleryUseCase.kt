package com.example.m19_location.domain

import com.example.m19_location.data.GalleryRepository
import com.example.m19_location.entity.Gallery
import javax.inject.Inject

class GetGalleryUseCase @Inject constructor(val galleryRepository: GalleryRepository) {

    suspend fun onAdd(gallery: Gallery) {
        galleryRepository.onAdd(gallery)
    }

    suspend fun onUpdate(gallery: Gallery) {
        galleryRepository.onUpdate(gallery)
    }

    suspend fun onDelete() {
        galleryRepository.onDelete()
    }

    suspend fun onContainsPhoto(photo: String): List<Gallery> {
        return galleryRepository.onContainsPhoto(photo)
    }

    suspend fun onContainsDate(date: String): List<Gallery> {
        return galleryRepository.onContainsDate(date)
    }
}
