package com.example.testtask.presentation.ui

import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object EnterScreen : SupportAppScreen() {
        override fun getFragment() = RegistrationFragment()
    }

    object WelcomeScreen : SupportAppScreen() {
        override fun getFragment() = WelcomeFragment()
    }
}