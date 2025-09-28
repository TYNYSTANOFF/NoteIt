package com.example.noteit

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class Pref(context: Context) {
    val pref: SharedPreferences = context.getSharedPreferences(
        AppKey.KEY_BOARD_PREF,
        Context.MODE_PRIVATE
    )

    fun setState (state : Boolean){
        pref.edit{
            putBoolean(AppKey.KEY_BOARD_STATE, state).apply()
        }
    }
    fun getState (): Boolean{
     return   pref.getBoolean(AppKey.KEY_BOARD_STATE, false)
    }
}