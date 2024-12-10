package com.example.m19_location.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "gallery")
data class Gallery(
    @PrimaryKey
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "date")
    val date: String
): Serializable
