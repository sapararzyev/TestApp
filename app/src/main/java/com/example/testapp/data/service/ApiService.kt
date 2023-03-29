package com.example.testapp.data.service

import com.example.testapp.BuildConfig.API_KEY
import com.example.testapp.data.dto.Hit
import com.example.testapp.data.dto.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api")
    suspend fun getImage(
        @Query("key") key: String = API_KEY,
    ): PixabayResponse<Hit>
}