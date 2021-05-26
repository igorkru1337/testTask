package com.example.testtask.domain.repository

interface PersonRepository {

    fun setPerson(name: String)

    fun getPerson(): String?

    fun deletePerson()
}