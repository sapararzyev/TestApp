package com.example.testapp.presentation.model

import com.example.testapp.domain.model.HitModel

data class HitUI(
    val id: Int,
    val largeImageURL: String,
    val pageURL: String,
    val previewURL: String,
)

fun HitModel.toUI() = HitUI(
    id = id,
    largeImageURL = largeImageURL,
    pageURL = pageURL,
    previewURL = previewURL
)