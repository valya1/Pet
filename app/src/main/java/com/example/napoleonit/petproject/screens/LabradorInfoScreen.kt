package com.example.napoleonit.petproject.screens

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class LabradorInfoScreen: SupportAppScreen() {

    override fun getFragment(): Fragment {
        return LabradorFragment()
    }

    override fun getScreenKey(): String {
        return super.getScreenKey()
    }
}