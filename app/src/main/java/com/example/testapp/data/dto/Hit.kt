package com.example.testapp.data.dto

import com.example.testapp.data.mapper.DataMapper
import com.example.testapp.domain.model.HitModel

data class Hit(
    val id: Int,
    val largeImageURL: String,
    val pageURL: String,
    val previewURL: String,
) : DataMapper<HitModel> {

    override fun toDomain() = HitModel(
        id = id,
        largeImageURL = largeImageURL,
        pageURL = pageURL,
        previewURL = previewURL
    )
}