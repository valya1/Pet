package com.example.napoleonit.petproject.root

import com.arellomobile.mvp.InjectViewState
import com.example.napoleonit.petproject.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RootPresenter @Inject constructor(override val router: Router) : BasePresenter<RootView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.navigateTo()

    }
}