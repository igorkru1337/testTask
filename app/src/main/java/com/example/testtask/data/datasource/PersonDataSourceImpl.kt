package com.example.testtask.data.datasource

import android.content.Context

class PersonDataSourceImpl(context: Context) : PersonDataSource {

    val PREFERENCE_NAME = "SharedPreference"
    val PREFERENCE_NAME_STRING = "NameString"

    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    override fun setPerson(name: String) {
        val editor = preference.edit()
        editor.putString(PREFERENCE_NAME_STRING, name)
        editor.apply()
    }

    override fun getPerson(): String? = preference.getString(PREFERENCE_NAME_STRING, null)

    override fun deletePerson() {
        val editor = preference.edit()
        editor.putString(PREFERENCE_NAME_STRING, null)
        editor.apply()
    }

}