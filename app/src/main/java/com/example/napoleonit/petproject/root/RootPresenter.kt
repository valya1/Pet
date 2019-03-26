package com.example.napoleonit.petproject.root

import com.arellomobile.mvp.InjectViewState
import com.example.napoleonit.petproject.base.mvp.BasePresenter
import com.example.napoleonit.petproject.tabs.base.TabScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RootPresenter @Inject constructor(override val router: Router) : BasePresenter<RootView>() {

    fun goTo(tab: TabScreen) = router.navigateTo(tab)
}