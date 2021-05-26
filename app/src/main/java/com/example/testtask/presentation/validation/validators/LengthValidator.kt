package com.example.testtask.presentation.validation.validators

import com.example.testtask.presentation.validation.Validator

class LengthValidator : Validator<String> {

    companion object {
        private const val lengthMoreSix = 6
        private const val errorMessage: String = "Должно быть больше 6 символов"
    }

    override fun isValid(value: String): Boolean = lengthMoreSix < value.length

    override fun getError(): String = errorMessage
}