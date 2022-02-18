package com.test.codingchallenge.data.repository

import com.test.codingchallenge.data.api.StartWarsApiService
import com.test.codingchallenge.data.model.BaseResponse
import com.test.codingchallenge.data.model.FilmRes
import com.test.codingchallenge.data.model.People
import com.test.codingchallenge.data.model.Population
import com.test.codingchallenge.exposed.model.Film
import com.test.codingchallenge.extension.parseResponse
import com.test.codingchallenge.utils.CodingChallengeCallback
import com.test.codingchallenge.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class StartWarsRepositoryImpl : StartWarsRepository {
    override fun getEyeColors(callback: CodingChallengeCallback<List<String>>) {
        StartWarsApiService
            .create()
            .getPeopleEyeColor()
            .enqueue(object : Callback<BaseResponse<People>> {
                override fun onResponse(
                    call: Call<BaseResponse<People>>,
                    response: Response<BaseResponse<People>>
                ) {
                    val result = response.parseResponse { data ->
                        return@parseResponse data
                            .results
                            .take(5)
                            .map { it.eyeColor }
                    }
                    callback.onResponse(result)
                }

                override fun onFailure(call: Call<BaseResponse<People>>, t: Throwable) {
                    callback.onResponse(Resource.Failed(t.localizedMessage ?: ""))
                }
            })
    }

    override fun getPopulations(callback: CodingChallengeCallback<List<String>>) {
        StartWarsApiService
            .create()
            .getPopulations()
            .enqueue(object : Callback<BaseResponse<Population>> {
                override fun onResponse(
                    call: Call<BaseResponse<Population>>,
                    response: Response<BaseResponse<Population>>
                ) {
                    val result = response.parseResponse { data ->
                        return@parseResponse data.results
                            .filter { it.population != "unknown" }
                            .take(5)
                            .map { it.population }
                    }
                    callback.onResponse(result)
                }

                override fun onFailure(call: Call<BaseResponse<Population>>, t: Throwable) {
                    callback.onResponse(Resource.Failed(t.localizedMessage ?: ""))
                }
            })
    }

    override fun getFilms(callback: CodingChallengeCallback<List<Film>>) {
        StartWarsApiService
            .create()
            .getFilms()
            .enqueue(object : Callback<BaseResponse<FilmRes>> {
                override fun onResponse(
                    call: Call<BaseResponse<FilmRes>>,
                    response: Response<BaseResponse<FilmRes>>
                ) {
                    val result = response.parseResponse { data ->
                        return@parseResponse data.results
                            .map { it.toPublicFilm() }
                    }
                    callback.onResponse(result)
                }

                override fun onFailure(call: Call<BaseResponse<FilmRes>>, t: Throwable) {
                    callback.onResponse(Resource.Failed(t.localizedMessage ?: ""))
                }
            })
    }
}