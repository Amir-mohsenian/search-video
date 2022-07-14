package com.example.filmnet.data.model

import com.example.filmnet.ui.model.VideoEntity

fun VideoResponse.asEntity() = VideoEntity(
    id, status, title, slug, rate, year
)