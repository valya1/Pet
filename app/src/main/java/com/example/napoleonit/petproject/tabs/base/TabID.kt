package com.example.napoleonit.petproject.tabs.base

import com.example.napoleonit.petproject.tabs.dog.DogScreen
import ru.terrakok.cicerone.Screen

enum class TabID(val tabName: String) {
    DOG("dog"),
    CAT("cat")
}

//
//fun TabID.toScreen(): Screen {
//    return when {
//        this == TabID.DOG -> DogScreen()
//        else -> DogScreen()
//    }
//}