package com.example.filmnet.di

import com.example.filmnet.data.repository.FilmnetRemoteDataSource
import com.example.filmnet.data.repository.FilmnetRemoteDataSourceImp
import com.example.filmnet.data.repository.FilmnetRepository
import com.example.filmnet.data.repository.FilmnetRepositoryImp
import com.example.filmnet.network.RetrofitService
import dagger.Binds
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

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideFilmnetRemoteDataSource(filmnetRemoteDataSourceImp: FilmnetRemoteDataSourceImp): FilmnetRemoteDataSource

    @Singleton
    @Binds
    abstract fun provideFilmnetRepository(filmnetRepositoryImp: FilmnetRepositoryImp): FilmnetRepository
}