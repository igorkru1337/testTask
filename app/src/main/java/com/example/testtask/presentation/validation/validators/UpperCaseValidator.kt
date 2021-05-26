package com.example.testtask.presentation.validation.validators

import com.example.testtask.presentation.validation.Validator

class UpperCaseValidator : Validator<String> {

    companion object {
        private const val UpperCaseRegexString = ".*[A-Z].*"
        private const val ErrorMessage = "Пароль должен содержать буквы вернего регистра"
    }

    override fun isValid(value: String): Boolean = value.matches(UpperCaseRegexString.toRegex())

    override fun getError(): String = ErrorMessage
}
