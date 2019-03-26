package com.example.napoleonit.petproject.tabs.dog


import com.example.napoleonit.petproject.tabs.base.TabContainer
import com.example.napoleonit.petproject.tabs.base.TabID
import com.example.napoleonit.petproject.screens.LabradorInfoScreen

class DogTabContainer : TabContainer() {

    override val firstScreen = LabradorInfoScreen()

    override val tabId = TabID.DOG
}
