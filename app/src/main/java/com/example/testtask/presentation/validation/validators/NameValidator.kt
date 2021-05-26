package com.example.testtask.presentation.validation.validators

import com.example.testtask.presentation.validation.Validator

class NameValidator : Validator<String> {

    companion object {
        private const val spaceChar = " "
        private const val errorMessage = "Имя и Фамилия должны быть без пробелов"
    }

    override fun isValid(value: String): Boolean = !value.contains(spaceChar)

    override fun getError(): String = errorMessage
}