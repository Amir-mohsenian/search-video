package com.example.filmnet.data.repository

import com.example.filmnet.ui.model.VideoEntity
import com.example.filmnet.util.Result

interface FilmnetRemoteDataSource {
    suspend fun getVideosByQuery(query: String): Result<List<VideoEntity>>
}