package com.example.napoleonit.petproject.base.mvp

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import ru.terrakok.cicerone.Router


abstract class BasePresenter<V: MvpView>: MvpPresenter<V>(){

    abstract val router: Router
}