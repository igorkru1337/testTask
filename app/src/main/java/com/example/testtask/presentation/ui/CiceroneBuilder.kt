package com.example.testtask.presentation.ui

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

fun buildCicerone(): Cicerone<Router> =
    Cicerone.create().also {
        it.router.newRootScreen(Screens.EnterScreen)
    }