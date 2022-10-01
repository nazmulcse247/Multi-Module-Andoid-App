package com.example.data.network.utils

import android.content.ContentValues.TAG
import android.util.Log
import com.example.common.utils.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

 class SafeApiRequest @Inject constructor() {

    suspend fun <T : Any> safeApiRequest(call : suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val responseErr = response.errorBody()?.string()
            val message = StringBuilder()
            responseErr.let {
                try {
                    message.append(JSONObject(it).getString("error"))
                }
                catch (e: JSONException) {
                }
            }
            Log.d("TAG", "safeApiRequest: ${message.toString()}")
            throw ApiException(message.toString())
        }
    }

    suspend fun<ResultType> downloadData(api : suspend () -> Response<ResultType>): Flow<ApiResult<ResultType>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    emit(ApiResult.Loading(true))
                    val response: Response<ResultType> = api()
                    emit(ApiResult.Loading(false))
                    if (response.isSuccessful){
                        response.body()?.let {
                            emit(ApiResult.Success(data = it))
                        }?: emit(ApiResult.Error(message = "Unknown error occurred", code = 0))
                    }else{
                        emit(ApiResult.Error(message = "", code = response.code()))
                    }
                }catch (e:Exception){
                    emit(ApiResult.Loading(false))
                    emit(ApiResult.Error(message = "", code =0))
                }
            }
        }
    }
}