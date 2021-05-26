package com.example.testtask.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.testtask.domain.usecases.DeletePersonUseCase
import com.example.testtask.domain.usecases.GetPersonUseCase
import ru.terrakok.cicerone.Router

class WelcomeViewModel(
    override var router: Router,
    private val getPersonUseCase: GetPersonUseCase,
    private val deletePersonUseCase: DeletePersonUseCase
) : BaseViewModel(router) {

    val nameLiveData = MutableLiveData<String>("")

    init {
        loadName()
    }

    private fun loadName() {
        nameLiveData.value = getPersonUseCase.invoke()
    }

    fun clearData() {
        deletePersonUseCase.invoke()
    }
}