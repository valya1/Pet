package com.example.napoleonit.petproject.tabs.base

import ru.terrakok.cicerone.android.support.SupportAppScreen

abstract class TabScreen : SupportAppScreen() {

    abstract val container: TabContainer

    override fun getFragment() = container

}
