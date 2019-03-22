package com.example.napoleonit.petproject.tabs.dog

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class DogScreen: SupportAppScreen() {

    override fun getFragment(): Fragment = DogTabContainer()
}