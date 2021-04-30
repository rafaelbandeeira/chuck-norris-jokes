package com.rafaelbandeeira.chucknorrisjokes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelbandeeira.chucknorrisjokes.network.JokeMapper
import com.rafaelbandeeira.chucknorrisjokes.network.JokesRemote
import com.rafaelbandeeira.chucknorrisjokes.network.JokesInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _joke: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val joke = _joke as LiveData<String>

    fun getJokes() {
        val jokesInterface = JokesInterface.create().getRandomJoke()

        jokesInterface.enqueue( object : Callback<JokesRemote> {
            override fun onResponse(call: Call<JokesRemote>, response: Response<JokesRemote>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        val jokeValue = JokeMapper.toDomain(it)
                        _joke.value = jokeValue.text
                    }
                }
            }

            override fun onFailure(call: Call<JokesRemote>, t: Throwable) { }
        })
    }
}