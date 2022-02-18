package com.test.codingchallenge.utils


sealed class Resource<T> {
    fun isSuccess() = this is Success
    data class Success<T>(val data: T) : Resource<T>()
    data class Failed<T>(val error: String) : Resource<T>()
}
