package com.test.codingchallenge.data.repository

import com.test.codingchallenge.exposed.model.Film
import com.test.codingchallenge.utils.CodingChallengeCallback

internal interface StartWarsRepository{
    fun getEyeColors(callback: CodingChallengeCallback<List<String>>)

    fun getPopulations(callback: CodingChallengeCallback<List<String>>)

    fun getFilms(callback: CodingChallengeCallback<List<Film>>)
}