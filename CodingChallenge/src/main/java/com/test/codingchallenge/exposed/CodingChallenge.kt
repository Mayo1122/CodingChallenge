package com.test.codingchallenge.exposed

import com.test.codingchallenge.utils.CodingChallengeCallback
import com.test.codingchallenge.data.repository.StartWarsRepository
import com.test.codingchallenge.data.repository.StartWarsRepositoryImpl
import com.test.codingchallenge.exposed.model.Film

/**
 * CodingChallenge is a entry point to SDK.
 *
 * For using SDK features, an instance is needed.
 * Instance can be created by using CodingChallenge.Builder, using builder pattern configuration can be done.
 * Its recommended to create instance in Application class onCreate method. After this it can used anywhere.
 *
 * You can simply call features like
 * CodingChallenge.getInstance().getEyeColors(callback here)
 */

class CodingChallenge internal constructor(private val repository: StartWarsRepository) {

    companion object {
        private var _instance: CodingChallenge? = null

        @JvmStatic
        fun getInstance(): CodingChallenge {
            return _instance ?: throw IllegalStateException("Create Instance first using CodingChallenge.Builder")
        }
    }
    /**
     * Responsible for creating instance of CodingChallenge
     * */
    class Builder {
        fun build(): CodingChallenge {
            val temp = CodingChallenge(StartWarsRepositoryImpl())
            _instance = temp
            return temp
        }
    }

    /**
     * Return the eye colors of 5 different people
     * */
    fun getEyeColors(callback: CodingChallengeCallback<List<String>>) = repository.getEyeColors(callback)

    /**
     * Return the population of 5 different planets
     * */
    fun getPopulations(callback: CodingChallengeCallback<List<String>>) = repository.getPopulations(callback)

    /**
     * Return the all available films data
     * */
    fun getFilms(callback: CodingChallengeCallback<List<Film>>) = repository.getFilms(callback)
}
