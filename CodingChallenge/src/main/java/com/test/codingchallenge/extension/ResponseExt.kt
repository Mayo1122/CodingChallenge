package com.test.codingchallenge.extension

import com.test.codingchallenge.utils.Resource
import retrofit2.Response
import java.lang.NullPointerException

internal fun <T,R> Response<T>.parseResponse(map:(T)->R): Resource<R> {
    return if (isSuccessful) {
        if (body() != null){
            Resource.Success(map(body()!!))
        }else{
            throw NullPointerException("Response is null")
        }
    } else {
        Resource.Failed(errorBody().toString())
    }
}