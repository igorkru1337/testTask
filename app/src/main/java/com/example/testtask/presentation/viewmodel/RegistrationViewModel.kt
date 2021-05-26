package com.example.testtask.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.testtask.domain.usecases.GetPersonUseCase
import com.example.testtask.domain.usecases.SetPersonUseCase
import ru.terrakok.cicerone.Router
import java.text.SimpleDateFormat
import java.util.*

class RegistrationViewModel(
    override var router: Router,
    private val setPersonUseCase: SetPersonUseCase,
    private val getPersonUseCase: GetPersonUseCase
) : BaseViewModel(router) {

    val firstNameLiveData = MutableLiveData<String>()
    val secondNameLiveData = MutableLiveData<String>()
    val birthDateLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val confirmPasswordLiveData = MutableLiveData<String>()
    val firstNameErrorLiveData = MutableLiveData<String>()
    val secondNameErrorLiveData = MutableLiveData<String>()
    val dateBirthErrorLiveData = MutableLiveData<String>()
    val passwordErrorLiveData = MutableLiveData<String>()
    val confirmPasswordErrorLiveData = MutableLiveData<String>()
    var sharedPreferenceCache: String? = null

    fun finishRegistration(name: String) {
        setPersonUseCase(name)
    }

    init {
        loadName()
    }

    fun isAlreadyRegistration(): Boolean = (sharedPreferenceCache != null)


    fun converterDate(date: Long?) {
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale("ru"))
        val dateString = String.format(formatter.format(date))
        birthDateLiveData.value = dateString
    }

    fun isValid(): Boolean = when {
        firstNameErrorLiveData.value != null -> false
        secondNameErrorLiveData.value != null -> false
        dateBirthErrorLiveData.value != null -> false
        passwordErrorLiveData.value != null -> false
        confirmPasswordErrorLiveData.value != null -> false
        else -> true
    }

    private fun loadName() {
        sharedPreferenceCache = getPersonUseCase.invoke()
    }
}