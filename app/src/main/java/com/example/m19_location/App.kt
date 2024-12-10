package com.example.m19_location

import android.app.Application
import androidx.room.Room
import com.example.m19_location.data.AppDatabase
import com.example.m19_location.utils.Constants
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(Constants.MY_API_KEY)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            name = "db"
        )
            .addMigrations(MIGRATION_0_1)
            .build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}
