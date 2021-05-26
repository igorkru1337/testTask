package com.example.testtask.domain.di

import com.example.testtask.domain.usecases.DeletePersonUseCase
import com.example.testtask.domain.usecases.GetPersonUseCase
import com.example.testtask.domain.usecases.SetPersonUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { SetPersonUseCase(get()) }
    factory { GetPersonUseCase(get()) }
    factory { DeletePersonUseCase(get()) }
}