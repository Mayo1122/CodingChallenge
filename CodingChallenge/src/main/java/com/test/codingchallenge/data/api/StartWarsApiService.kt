package com.test.codingchallenge.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.test.codingchallenge.data.model.BaseResponse
import com.test.codingchallenge.data.model.FilmRes
import com.test.codingchallenge.data.model.People
import com.test.codingchallenge.data.model.Population
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

internal interface StartWarsApiService {

    @GET(ApiTags.PEOPLE_URL)
    fun getPeopleEyeColor(): Call<BaseResponse<People>>

    @GET(ApiTags.PLANETS_URL)
    fun getPopulations(): Call<BaseResponse<Population>>

    @GET(ApiTags.FILMS_URL)
    fun getFilms(): Call<BaseResponse<FilmRes>>

    companion object {
        /**
         * Creates object of StartWarsApiService using Retrofit
         * */
        fun create(): StartWarsApiService {
            // print api logs
            val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client : OkHttpClient = OkHttpClient.Builder().apply {
                addInterceptor(interceptor)
            }.build()

            // for json parsing
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

            return Retrofit.Builder()
                .baseUrl(ApiTags.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
                .create(StartWarsApiService::class.java)
        }
    }
}
