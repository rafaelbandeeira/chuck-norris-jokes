package com.rafaelbandeeira.chucknorrisjokes

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokesInterface {
    @GET("random")
    fun getRandomJoke(): Call<Jokes>

    companion object {
        private const val BASE_URL = "https://api.chucknorris.io/jokes/"

        fun create() : JokesInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(JokesInterface::class.java)
        }
    }
}