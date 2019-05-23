package com.example.napoleonit.petproject.tabs.base

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen

fun Fragment.toScreen(): Screen {

    return object : SupportAppScreen() {
        override fun getFragment() = this@toScreen
    }


}