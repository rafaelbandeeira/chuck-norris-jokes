package com.rafaelbandeeira.chucknorrisjokes.data.remote.repository

import com.rafaelbandeeira.chucknorrisjokes.data.remote.datasource.JokeDatasource
import com.rafaelbandeeira.chucknorrisjokes.domain.model.Joke

class JokeRepositoryImpl(
    private val jokeDatasource: JokeDatasource
) : JokeRepository {

    override suspend fun getJoke(): Joke = jokeDatasource.getJoke()
}