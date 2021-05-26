package com.example.testtask.domain.usecases

import com.example.testtask.domain.repository.PersonRepository

class DeletePersonUseCase(private val personRepository: PersonRepository) {

    operator fun invoke(): String? = personRepository.getPerson()
}