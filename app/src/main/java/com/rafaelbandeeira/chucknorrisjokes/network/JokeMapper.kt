package com.rafaelbandeeira.chucknorrisjokes.network

import com.rafaelbandeeira.chucknorrisjokes.domain.model.Joke

fun JokesRemote.toDomain (): Joke {
    return Joke(
        text = this.value ?: "Joke not found."
    )
}