package com.example.testapp.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.core.Loading
import com.example.testapp.core.Success
import com.example.testapp.core.UIState
import com.example.testapp.domain.use_cases.GetImageUseCase
import com.example.testapp.presentation.model.HitUI
import com.example.testapp.presentation.model.toUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val getImageUseCase: GetImageUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UIState<List<HitUI>?>>(UIState.Loading())
    val state = _state.asStateFlow()

    init {
        getImage()
    }

    private fun getImage() {
        viewModelScope.launch(Dispatchers.IO) {
            getImageUseCase().collect { hitModel ->
                when (hitModel) {
                    is Success -> {
                        _state.value = UIState.Success(hitModel.data?.map { it.toUI() })
                    }
                    is Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is com.example.testapp.core.Error -> {
                        _state.value = UIState.Error(msg = hitModel.msg ?: "Error")
                    }
                }


            }
        }
    }
}