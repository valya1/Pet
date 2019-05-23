package com.example.napoleonit.petproject.screens.labrador

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class LabradorPresenter @Inject constructor(val router: Router) : MvpPresenter<LabradorView>() {

    override fun attachView(view: LabradorView?) {
        super.attachView(view)

        println("Router: $router")

    }

}