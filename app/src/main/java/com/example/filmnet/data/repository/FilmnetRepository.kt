package com.example.filmnet.data.repository

import com.example.filmnet.ui.model.VideoEntity
import com.example.filmnet.util.Result

interface FilmnetRepository {
    suspend fun findVideoByQuery(query: String): Result<List<VideoEntity>>
}