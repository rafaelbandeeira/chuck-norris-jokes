package com.rafaelbandeeira.chucknorrisjokes.data.remote.datasource

import com.rafaelbandeeira.chucknorrisjokes.domain.model.Joke

interface JokeDatasource {
    suspend fun getJoke() : Joke
}