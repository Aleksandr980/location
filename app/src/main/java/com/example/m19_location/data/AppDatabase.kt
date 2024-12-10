package com.example.m19_location.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.m19_location.entity.Gallery


@Database(entities = [Gallery::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun galleryDao(): GalleryDao
}
