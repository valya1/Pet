package com.example.napoleonit.petproject.root

import com.example.napoleonit.petproject.screens.LabradorFragment
import com.example.napoleonit.petproject.tabs.dog.DogTabContainer
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface RootModule {

    @ContributesAndroidInjector
    fun provideActivity(): RootActivity

    //todo убрать метод в отдельный модуль
    @ContributesAndroidInjector
    fun dogTabContainer(): DogTabContainer

    @ContributesAndroidInjector
    fun labradorFragment(): LabradorFragment
}