package com.example.domain.use_case

import com.example.common.utils.ApiResult
import kotlinx.coroutines.flow.Flow


interface UseCase

interface ApiUseCaseParams<Params, Type> : UseCase {
    suspend fun execute(params: Params): Flow<ApiResult<Type>>
}

interface ApiUseCaseNonParams<Type> : UseCase {
    suspend fun execute(): Flow<ApiResult<Type>>
}