package com.example.filmnet.data.model

import com.google.gson.annotations.SerializedName

class VideoResponse(
    @SerializedName("status") val status: String,
    @SerializedName("title") val title: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("summary") val summary: String,
    @SerializedName("rate") val rate: Float,
    @SerializedName("year") val year: Int,
    @SerializedName("id") val id: String,
) {
}