package com.example.filmnet.network

import com.google.gson.annotations.SerializedName

class BaseResponse<out T>(
    @SerializedName("data") val data: T?
) {
}