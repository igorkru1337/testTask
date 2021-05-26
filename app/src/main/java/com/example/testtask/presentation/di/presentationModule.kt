package com.example.testtask.presentation.di

import com.example.testtask.presentation.viewmodel.RegistrationViewModel
import com.example.testtask.presentation.viewmodel.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        RegistrationViewModel(
            router = get(),
            setPersonUseCase = get(),
            getPersonUseCase = get()
        )
    }
    viewModel {
        WelcomeViewModel(
            router = get(),
            getPersonUseCase = get(),
            deletePersonUseCase = get()
        )
    }
}