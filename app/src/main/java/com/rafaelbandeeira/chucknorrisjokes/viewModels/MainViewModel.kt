package com.rafaelbandeeira.chucknorrisjokes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelbandeeira.chucknorrisjokes.data.remote.repository.JokeRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val jokeRepository: JokeRepository
) : ViewModel() {
    private val _joke: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val joke = _joke as LiveData<String>

    fun getJokes() {
        GlobalScope.launch {
            val jokeResponse = jokeRepository.getJoke()
            _joke.value = jokeResponse.text
        }
    }
}