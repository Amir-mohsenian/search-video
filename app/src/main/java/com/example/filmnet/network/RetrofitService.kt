package com.example.filmnet.network

import com.example.filmnet.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/search")
    suspend fun getSearchResponse(@Query("query") query: String): Response<BaseResponse<SearchResponse>>
}