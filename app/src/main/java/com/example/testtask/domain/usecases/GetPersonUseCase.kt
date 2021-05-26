package com.example.testtask.domain.usecases

import com.example.testtask.domain.repository.PersonRepository

class GetPersonUseCase(private val personRepository: PersonRepository) {

    operator fun invoke(): String? = personRepository.getPerson()
}