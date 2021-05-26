package com.example.testtask.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testtask.R
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private val layout: Int = R.layout.main_activity

    private val navigatorHolder: NavigatorHolder by inject()
    private val navigator = SupportAppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        navigatorHolder.setNavigator(navigator)
    }

    override fun onStop() {
        super.onStop()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
    }
}