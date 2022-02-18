package com.test.codingchallenge.data.model

import com.squareup.moshi.Json

internal data class People(@Json(name = "eye_color") val eyeColor: String)