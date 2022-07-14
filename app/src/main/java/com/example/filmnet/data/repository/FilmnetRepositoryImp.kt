package com.example.filmnet.data.repository

import com.example.filmnet.ui.model.VideoEntity
import com.example.filmnet.util.Result
import javax.inject.Inject

class FilmnetRepositoryImp @Inject constructor(private val remoteDataSource: FilmnetRemoteDataSource) :
    FilmnetRepository {
    override suspend fun findVideoByQuery(query: String): Result<List<VideoEntity>> =
        remoteDataSource.getVideosByQuery(query)

}