package com.test.codingchallenge.utils

interface CodingChallengeCallback<T : Any> {
    fun onResponse(result: Resource<T>)
}