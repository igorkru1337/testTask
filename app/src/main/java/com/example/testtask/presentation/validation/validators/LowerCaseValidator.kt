package com.example.testtask.presentation.validation.validators

import com.example.testtask.presentation.validation.Validator

class LowerCaseValidator : Validator<String> {

    companion object {
        private const val LowerCaseRegexString = ".*[a-z].*"
        private const val errorMessage = "Пароль должен содержать буквы нижнего регистра"
    }

    override fun isValid(value: String): Boolean = value.matches(LowerCaseRegexString.toRegex())

    override fun getError(): String = errorMessage
}