package com.rafaelbandeeira.chucknorrisjokes.data.remote

import com.rafaelbandeeira.chucknorrisjokes.network.JokesRemote
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokesInterface {
    @GET("random")
    suspend fun getRandomJoke(): JokesRemote

    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }
}