package com.rafaelbandeeira.chucknorrisjokes.DiModule

import com.rafaelbandeeira.chucknorrisjokes.viewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
}