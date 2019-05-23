package com.example.napoleonit.petproject.base.ui

import com.example.napoleonit.petproject.base.mvp.BaseFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

abstract class ScreenFragment : BaseFragment() {

    val screen = object : SupportAppScreen() {
        override fun getFragment() = this@ScreenFragment
    }

}