package com.example.filmnet.domain

import com.example.filmnet.data.repository.FilmnetRepository
import javax.inject.Inject

class SearchVideoUseCase @Inject constructor(
    private val repository: FilmnetRepository
) {
    suspend operator fun invoke(query: String) = repository.findVideoByQuery(query)
}