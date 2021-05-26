package com.example.testtask.data.datasource

interface PersonDataSource {

    fun setPerson(name: String)

    fun getPerson(): String?

    fun deletePerson()
}