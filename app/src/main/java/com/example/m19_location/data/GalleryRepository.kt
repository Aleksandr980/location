package com.example.m19_location.data

import com.example.m19_location.entity.Gallery
import javax.inject.Inject

class GalleryRepository @Inject constructor(val galleryDao: GalleryDao){

    suspend fun onAdd(gallery: Gallery) {
        galleryDao.insert(gallery)
    }

    suspend fun onUpdate(gallery: Gallery) {
        galleryDao.update(gallery)
    }

    suspend fun onDelete() {
        galleryDao.delete()
    }

    suspend fun onContainsPhoto(photo: String): List<Gallery> {
        return galleryDao.containsPhoto(photo)
    }
    suspend fun onContainsDate(date: String): List<Gallery> {
        return galleryDao.containsDate(date)
    }

}