package com.example.filmnet.di

import com.example.filmnet.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit) = retrofit.create(RetrofitService::class.java)
}