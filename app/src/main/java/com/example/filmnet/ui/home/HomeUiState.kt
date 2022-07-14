package com.example.filmnet.ui.home

import com.example.filmnet.ui.model.VideoEntity

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val isEmptyList: Boolean = false,
    val videoList: List<VideoEntity> = emptyList()
)
