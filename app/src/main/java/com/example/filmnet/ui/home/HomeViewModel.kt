package com.example.filmnet.ui.home

import com.example.filmnet.domain.SearchVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchVideoUseCase: SearchVideoUseCase
) {
}