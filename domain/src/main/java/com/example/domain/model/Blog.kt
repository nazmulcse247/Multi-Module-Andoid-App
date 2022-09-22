package com.example.domain.model

data class Blog(
    val id: String,
    val image: String,
    val publishDate: String?,
    val text: String,
    val owner: Owner
)
