package com.example.testapp.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}