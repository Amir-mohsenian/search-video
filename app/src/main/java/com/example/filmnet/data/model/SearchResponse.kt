package com.example.filmnet.data.model

import com.google.gson.annotations.SerializedName

class SearchResponse(
    @SerializedName("videos") val videos: List<VideoResponse>
) {
}