package com.example.napoleonit.petproject.subnavigation

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class LocalCiceroneHolder {

    private val tabCicerones = hashMapOf<String, Cicerone<Router>>()

    fun getCicerone(tabId: String): Cicerone<Router> {
        if (!tabCicerones.contains(tabId))
            tabCicerones[tabId] = Cicerone.create()
        return tabCicerones[tabId]!!
    }




}