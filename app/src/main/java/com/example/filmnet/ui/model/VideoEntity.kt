package com.example.filmnet.ui.model

data class VideoEntity(
    val id: String,
    val status: String,
    val title: String,
    val description: String,
    val rate: Float,
    val year: Int
)
