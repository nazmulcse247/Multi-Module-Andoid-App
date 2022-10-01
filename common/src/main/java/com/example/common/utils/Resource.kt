package com.example.common.utils

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    class Loading<T>(data: T? = null) : Resource<T>(data)

}

sealed class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Loading<out T>(val loading: Boolean) : ApiResult<T>()
    data class Error<out T>(val message: String,val code:Int) : ApiResult<T>()
}
