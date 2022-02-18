package com.test.codingchallengesample

import android.app.Application
import com.test.codingchallenge.exposed.CodingChallenge

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        // usage
        CodingChallenge.Builder().build()
    }
}