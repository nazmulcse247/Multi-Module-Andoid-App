package com.example.presentation.blog_post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.Resource
import com.example.domain.use_case.GetBlogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(private val getBlogUseCase : GetBlogUseCase) :ViewModel() {

    private val _blogList = MutableStateFlow(BlogState())
    val blogList : StateFlow<BlogState> = _blogList


    fun getBlog(){
        getBlogUseCase().onEach {
            when(it){
                is Resource.Loading -> {
                    _blogList.value = BlogState(isLoading = true)
                }

                is Resource.Success -> {
                    _blogList.value = BlogState(data = it.data)
                }
                is Resource.Error -> {
                    _blogList.value = BlogState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}