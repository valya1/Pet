package com.example.napoleonit.petproject.tabs.cat

import com.example.napoleonit.petproject.tabs.base.TabContainer
import com.example.napoleonit.petproject.tabs.base.TabID
import com.example.napoleonit.petproject.tabs.base.toScreen
import ru.terrakok.cicerone.Screen

class CatTabContaner: TabContainer() {

    override val firstScreen: Screen?
        get() = CatInfoFragment().toScreen()

    override val tabId: TabID
        get() = TabID.CAT

}
