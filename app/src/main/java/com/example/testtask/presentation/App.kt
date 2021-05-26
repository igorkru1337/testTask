package com.example.testtask.presentation

import android.app.Application
import com.example.testtask.data.di.dataModule
import com.example.testtask.di.appModule
import com.example.testtask.domain.di.domainModule
import com.example.testtask.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    presentationModule,
                    appModule,
                )
            )
        }

    }
}