package com.example.testtask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

abstract class BaseViewModel(open var router: Router) : ViewModel() {

    fun navigateTo(screen: Screen) {
        router.navigateTo(screen)
    }
}