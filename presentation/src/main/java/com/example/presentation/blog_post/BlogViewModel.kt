package com.example.presentation.blog_post

import androidx.lifecycle.ViewModel
import com.example.common.utils.ApiResult
import com.example.common.utils.BaseViewModel
import com.example.domain.use_case.GetBlogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(private val getBlogUseCase : GetBlogUseCase) : ViewModel() {

    private val _blogList = MutableStateFlow<BlogState>(BlogState())
    val blogList : StateFlow<BlogState> = _blogList

    init {
        getBlog()
    }

    fun getBlog(){




        }
    }
