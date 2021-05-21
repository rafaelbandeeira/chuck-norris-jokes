package com.rafaelbandeeira.chucknorrisjokes.data.remote.datasource

import com.rafaelbandeeira.chucknorrisjokes.data.remote.JokesInterface
import com.rafaelbandeeira.chucknorrisjokes.network.toDomain

class JokeDatasourceImpl(
    private val jokesInterface : JokesInterface
) : JokeDatasource {

    override suspend fun getJoke() = jokesInterface.getRandomJoke().toDomain()

}