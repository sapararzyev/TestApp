package com.example.testapp.data.repository

import com.example.testapp.core.Loading
import com.example.testapp.core.Resource
import com.example.testapp.core.Success
import com.example.testapp.data.service.ApiService
import com.example.testapp.domain.model.HitModel
import com.example.testapp.domain.repository.PixabayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PixabayRepositoryImpl(private val api: ApiService) : PixabayRepository {

    override fun getImage(): Flow<Resource<List<HitModel>>> = flow {
        try {
            emit(Loading())
            val result = api.getImage()
            emit(Success(result.hits.map { it.toDomain() }))
        } catch (e: IOException) {
            emit(com.example.testapp.core.Error(msg = "$e"))
        } catch (e: HttpException) {
            emit(com.example.testapp.core.Error(msg = "$e"))
        }
    }
}