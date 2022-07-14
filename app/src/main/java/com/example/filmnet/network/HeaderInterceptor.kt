package com.example.filmnet.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder().addHeader("X-Platform" , "Android")
        return chain.proceed(requestBuilder.build())
    }
}