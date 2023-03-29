package com.example.testapp.domain.use_cases

import com.example.testapp.domain.repository.PixabayRepository

class GetImageUseCase(private val repository: PixabayRepository) {
    operator fun invoke() = repository.getImage()
}
