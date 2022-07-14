package com.example.filmnet.data.model

import com.google.gson.annotations.SerializedName

class CategoryResponse(
    @SerializedName("type") val type: String,
    @SerializedName("items") val items: List<Item>
) {
    inner class Item(@SerializedName("title") val title: String)
}