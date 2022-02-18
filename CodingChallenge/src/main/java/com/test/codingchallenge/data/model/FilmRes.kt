package com.test.codingchallenge.data.model

import com.squareup.moshi.Json
import com.test.codingchallenge.exposed.model.Film

internal data class FilmRes(
    val title: String,
    @Json(name = "opening_crawl") val openingCrawl: String,
    @Json(name = "release_date") val releaseDate: String
){
    fun toPublicFilm(): Film {
        return Film(title, openingCrawl, releaseDate)
    }
}