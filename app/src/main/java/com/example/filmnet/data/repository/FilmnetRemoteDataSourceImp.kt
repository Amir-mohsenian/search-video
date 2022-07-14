package com.example.filmnet.data.repository

import com.example.filmnet.data.model.asEntity
import com.example.filmnet.network.RetrofitService
import com.example.filmnet.ui.model.VideoEntity
import com.example.filmnet.util.ErrorEntity
import com.example.filmnet.util.Result
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FilmnetRemoteDataSourceImp @Inject constructor(
    private val retrofitService: RetrofitService
) : FilmnetRemoteDataSource {
    override suspend fun getVideosByQuery(query: String): Result<List<VideoEntity>> {
        if (query.isEmpty()) {
            return Result.Error(ErrorEntity.Unknown(1000, "Query is Empty"))
        }
        return try {
            val response = retrofitService.getSearchResponse(query)

            if (response.isSuccessful) {
                val body = response.body() ?: return Result.Error(ErrorEntity.Unknown(1001, "body is null"))
                if (body.data == null)
                    return Result.Error(ErrorEntity.Unknown(1002, "data is null"))
                val data = body.data
                val videos = data.videos.map {
                    it.asEntity()
                }
                Result.Success(videos)
            } else {
                return Result.Error(ErrorEntity.Connection(1003, "connection has problem"))
            }
        } catch (exception: Exception) {
            Result.Error(getError(exception))
        }
    }

    private fun getError(exception: Exception) = when (exception) {
        is HttpException -> {
            ErrorEntity.Connection(exception.code(), exception.localizedMessage ?: "")
        }
        is IOException -> {
            ErrorEntity.Connection(1004, exception.localizedMessage ?: "")
        }
        else -> {
            ErrorEntity.Unknown(1005, exception.localizedMessage ?: "")
        }
    }
}