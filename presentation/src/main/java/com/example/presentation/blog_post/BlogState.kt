package com.example.presentation.blog_post

import com.example.domain.model.Blog

data class BlogState(
    val isLoading: Boolean = false,
    val data: List<Blog>? = null,
    val error: String = ""
)
