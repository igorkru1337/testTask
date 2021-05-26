package com.example.testtask.data.repository

import com.example.testtask.data.datasource.PersonDataSource
import com.example.testtask.domain.repository.PersonRepository

class PersonRepositoryImpl(private val personDataSource: PersonDataSource) : PersonRepository {

    override fun setPerson(name: String) {
        personDataSource.setPerson(name)
    }

    override fun getPerson(): String? = personDataSource.getPerson()

    override fun deletePerson() {
        personDataSource.deletePerson()
    }

}