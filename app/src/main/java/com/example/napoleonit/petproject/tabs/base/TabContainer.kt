package com.example.napoleonit.petproject.tabs.base

import android.os.Bundle
import android.view.View
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.base.navigation.RouterProvider
import com.example.napoleonit.petproject.base.mvp.BaseFragment
import com.example.napoleonit.petproject.subnavigation.LocalCiceroneHolder
import ru.terrakok.cicerone.Router

import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

abstract class TabContainer : BaseFragment(), RouterProvider {


    abstract val firstScreen: Screen?
    abstract val tabId: TabID

    @Inject
    lateinit var localCiceroneHolder: LocalCiceroneHolder

    override val router: Router by lazy { localCiceroneHolder.getCicerone(tabId.tabName).router }

    private val navigator by lazy { SupportAppNavigator(activity, childFragmentManager, R.id.subTabContainer) }

    override fun getLayoutId() = R.layout.tab_contianer


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstScreen?.run(router::navigateTo)
    }

    override fun onResume() {
        super.onResume()

        tabId.toCicerone().navigatorHolder.setNavigator(navigator)

    }

    override fun onPause() {
        super.onPause()

        tabId.toCicerone().navigatorHolder.removeNavigator()
    }


    private fun TabID.toCicerone() = localCiceroneHolder.getCicerone(tabName)
}