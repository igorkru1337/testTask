package com.example.testtask.presentation.validation.validators

import com.example.testtask.presentation.validation.Validator

class EmptyValidator : Validator<String> {

    companion object {
        private const val error = "Поле не должно быть пустым"
    }

    override fun isValid(value: String): Boolean = value.isNotEmpty()

    override fun getError(): String = error
}