package com.example.filmnet.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmnet.domain.SearchVideoUseCase
import com.example.filmnet.ui.util.Event
import com.example.filmnet.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchVideoUseCase: SearchVideoUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    private val _errorMessage = MutableLiveData<Event<String>>()
    val errorMessageEvent: LiveData<Event<String>> = _errorMessage

    fun searchVideo(query: String) {
        _homeUiState.value = HomeUiState(isLoading = true)

        viewModelScope.launch {
            val result = searchVideoUseCase(query)
            _homeUiState.update { it.copy(isLoading = false) }

            when (result) {
                is Result.Success -> {
                    _homeUiState.update {
                        it.copy(isSuccess = true)
                    }

                    val videoList = result.data
                    if (videoList.isEmpty()) {
                        _homeUiState.update {
                            it.copy(isEmptyList = true)
                        }
                    } else {
                        _homeUiState.update {
                            it.copy(
                                isEmptyList = false, videoList = videoList
                            )
                        }
                    }
                }

                is Result.Error -> {
                    _errorMessage.value = Event(result.errorEntity.message)
                    _homeUiState.update {
                        it.copy(isError = true)
                    }
                }
            }
        }
    }
}