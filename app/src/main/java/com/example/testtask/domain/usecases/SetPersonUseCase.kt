package com.example.testtask.domain.usecases

import com.example.testtask.domain.repository.PersonRepository

class SetPersonUseCase(private val personRepository: PersonRepository) {

    operator fun invoke(name: String) {
        personRepository.setPerson(name)
    }
}