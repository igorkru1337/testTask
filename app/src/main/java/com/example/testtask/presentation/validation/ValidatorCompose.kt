package com.example.testtask.presentation.validation

interface Validator<T> {
    fun isValid(value: T): Boolean

    fun getError(): String?
}

class ValidatorComposer<T>(
    private val validators: List<Validator<T>>
) : Validator<T> {

    private var error: String? = null

    override fun isValid(value: T): Boolean {
        for (validator: Validator<T> in validators) {
            if (!validator.isValid(value)) {
                error = validator.getError()
            }
        }
        return true
    }

    override fun getError(): String? = error

}