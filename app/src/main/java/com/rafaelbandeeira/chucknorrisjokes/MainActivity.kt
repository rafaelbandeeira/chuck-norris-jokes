package com.rafaelbandeeira.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.mainButton)

        button.setOnClickListener {
            getJokes()
        }

    }

    fun getJokes() {
        val jokesInterface = JokesInterface.create().getRandomJoke()
        textView = findViewById(R.id.textview)
        jokesInterface.enqueue( object : Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>?, response: Response<Jokes>?) {
                if (response?.code() == 200) {
                    val responseBody = response.body()
                    textView.text = responseBody?.value
                }
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
