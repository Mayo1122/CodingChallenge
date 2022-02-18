package com.test.codingchallengesample

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.test.codingchallenge.utils.CodingChallengeCallback
import com.test.codingchallenge.exposed.CodingChallenge
import com.test.codingchallenge.exposed.model.Film
import com.test.codingchallenge.utils.Resource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CodingChallenge.getInstance().getEyeColors(callback = object : CodingChallengeCallback<List<String>> {
            override fun onResponse(result: Resource<List<String>>) {
                when (result){
                    is Resource.Success ->{
                        findViewById<TextView>(R.id.eyeColors).text = String.format(
                            getString(R.string.eye_colors),
                            result.data.toString()
                        )
                    }
                    is Resource.Failed ->{
                        showError(result.error)
                    }
                }
            }
        })

        CodingChallenge.getInstance().getPopulations(callback = object : CodingChallengeCallback<List<String>> {
            override fun onResponse(result: Resource<List<String>>) {
                when (result){
                    is Resource.Success ->{
                        findViewById<TextView>(R.id.populations).text = String.format(
                            getString(R.string.plant_populations),
                            result.data.toString()
                        )
                    }
                    is Resource.Failed ->{
                        showError(result.error)
                    }
                }
            }
        })

        CodingChallenge.getInstance().getFilms(callback = object : CodingChallengeCallback<List<Film>> {
            override fun onResponse(result: Resource<List<Film>>) {
                when (result){
                    is Resource.Success ->{
                        findViewById<TextView>(R.id.films).text = String.format(
                            getString(R.string.films),
                            result.data.toString()
                        )
                    }
                    is Resource.Failed ->{
                        showError(result.error)
                    }
                }
            }
        })
    }

    private fun showError(message: String){
        Log.d("TAG", "Error: $message")
        Toast.makeText(this@MainActivity,message, Toast.LENGTH_LONG).show()
    }
}