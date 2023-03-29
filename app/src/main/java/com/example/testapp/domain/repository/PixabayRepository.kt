package com.example.testapp.domain.repository

import com.example.testapp.core.Resource
import com.example.testapp.domain.model.HitModel
import kotlinx.coroutines.flow.Flow

interface PixabayRepository {
    fun getImage(): Flow<Resource<List<HitModel>>>
}