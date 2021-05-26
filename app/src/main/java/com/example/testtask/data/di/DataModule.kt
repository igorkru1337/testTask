package com.example.testtask.data.di

import com.example.testtask.data.datasource.PersonDataSource
import com.example.testtask.data.datasource.PersonDataSourceImpl
import com.example.testtask.data.repository.PersonRepositoryImpl
import com.example.testtask.domain.repository.PersonRepository
import org.koin.dsl.module

val dataModule = module {
    factory<PersonRepository> { PersonRepositoryImpl(get()) }
    factory<PersonDataSource> { PersonDataSourceImpl(get()) }
}