package com.rafaelbandeeira.chucknorrisjokes.network

import com.rafaelbandeeira.chucknorrisjokes.domain.model.Joke

object JokeMapper {
    fun toDomain (jokesRemote: JokesRemote): Joke {
        return Joke(
                text = jokesRemote.value ?: "Joke not found."
        )
    }
}