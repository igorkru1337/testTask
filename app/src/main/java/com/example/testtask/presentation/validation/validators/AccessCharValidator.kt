package com.example.testtask.presentation.validation.validators

import com.example.testtask.presentation.validation.Validator

class AccessCharValidator : Validator<String> {

    companion object {
        private const val charsRegexString = "([a-z]|[A-Z])*"
        private const val errorMessage = "Только латинскими буквами"
    }

    override fun isValid(value: String): Boolean = value.matches(charsRegexString.toRegex())

    override fun getError(): String = errorMessage
}