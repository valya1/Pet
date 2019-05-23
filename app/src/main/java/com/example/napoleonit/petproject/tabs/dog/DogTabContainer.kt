package com.example.napoleonit.petproject.tabs.dog


import com.example.napoleonit.petproject.screens.labrador.LabradorFragment
import com.example.napoleonit.petproject.tabs.base.TabContainer
import com.example.napoleonit.petproject.tabs.base.TabID

class DogTabContainer : TabContainer() {

    override val firstScreen = LabradorFragment().screen

    override val tabId = TabID.DOG
}
