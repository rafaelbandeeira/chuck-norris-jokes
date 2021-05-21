package com.rafaelbandeeira.chucknorrisjokes.diModule

import com.rafaelbandeeira.chucknorrisjokes.data.remote.JokesInterface
import com.rafaelbandeeira.chucknorrisjokes.data.remote.datasource.JokeDatasource
import com.rafaelbandeeira.chucknorrisjokes.data.remote.datasource.JokeDatasourceImpl
import com.rafaelbandeeira.chucknorrisjokes.data.remote.repository.JokeRepository
import com.rafaelbandeeira.chucknorrisjokes.data.remote.repository.JokeRepositoryImpl
import com.rafaelbandeeira.chucknorrisjokes.viewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { MainViewModel(get()) }

    factory<JokeRepository> {
        JokeRepositoryImpl(get())
    }

    factory<JokeDatasource> {
        JokeDatasourceImpl(get())
    }

    single<JokesInterface> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(JokesInterface.BASE_URL)
            .build()
            .create(JokesInterface::class.java)
    }
}