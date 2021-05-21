package com.rafaelbandeeira.chucknorrisjokes.data.remote.repository

import com.rafaelbandeeira.chucknorrisjokes.domain.model.Joke

interface JokeRepository {
    suspend fun getJoke() : Joke
}