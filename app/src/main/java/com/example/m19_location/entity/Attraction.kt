package com.example.m19_location.entity

import com.google.android.gms.maps.model.LatLng

 class Attractions(
    val latLng: LatLng,
    val name: String,
    val address: String,
    val content:String
)