package com.example.testapp.data.dto

data class PixabayResponse<T>(
    val hits: List<T>,
    val total: Int,
    val totalHits: Int
)