package com.rafaelbandeeira.chucknorrisjokes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelbandeeira.chucknorrisjokes.network.Jokes
import com.rafaelbandeeira.chucknorrisjokes.network.JokesInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _joke: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val joke = _joke as LiveData<String>

    fun getJokes() {
        val jokesInterface = JokesInterface.create().getRandomJoke()

        jokesInterface.enqueue( object : Callback<Jokes> {
            override fun onResponse(call: Call<Jokes?>?, response: Response<Jokes?>?) {
                if (response?.code() == 200) {
                    _joke.value = response.body()?.value
                }
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
            }
        })
    }
}