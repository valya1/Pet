package com.example.napoleonit.petproject.base

import android.os.Bundle
import android.view.View
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.subnavigation.LocalCiceroneHolder
import kotlinx.android.synthetic.main.main_layout.view.*

import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

abstract class TabContainer : BaseFragment() {

    abstract val firstScreen: Screen?
    abstract val tabId: TabID

    @Inject
    lateinit var localCiceroneHolder: LocalCiceroneHolder

    private val navigator by lazy { SupportAppNavigator(activity, childFragmentManager, R.id.mainContainer) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstScreen?.run {
            localCiceroneHolder.getCicerone(tabId.tabName)
        }
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