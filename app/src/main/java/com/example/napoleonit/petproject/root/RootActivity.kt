package com.example.napoleonit.petproject.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.base.TabID
import com.example.napoleonit.petproject.base.toScreen
import com.example.napoleonit.petproject.tabs.dog.DogScreen
import kotlinx.android.synthetic.main.main_layout.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class RootActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    @Inject
    lateinit var rootPresenter: RootPresenter

    private val navigator: SupportAppNavigator = object : SupportAppNavigator(this, R.id.mainContainer) {

        override fun setupFragmentTransaction(
            command: Command,
            currentFragment: Fragment,
            nextFragment: Fragment,
            fragmentTransaction: FragmentTransaction
        ) {
            fragmentTransaction.apply {
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_layout)

        navigator.applyCommands(arrayOf(Forward(DogScreen())))


        bottomNavigationView.setOnNavigationItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dog -> {
                    selectTab(TabID.DOG)
                }
                R.id.cat -> {
                    //todo реализовать
                }
            }
        }

    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }


    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }


    private fun selectTab(tabId: TabID) {

        val currentTab = supportFragmentManager.findFragmentById(R.id.mainContainer)
        val newTab = supportFragmentManager?.findFragmentByTag(tabId.tabName)
            ?: (tabId.toScreen() as? SupportAppScreen)?.fragment

        if (currentTab != null && newTab != null && currentTab != newTab) {

            supportFragmentManager.beginTransaction().apply {
                if (currentTab.isAdded)
                    hide(currentTab)
                if (!newTab.isAdded)
                    add(R.id.mainContainer, newTab, tabId.tabName)
                show(newTab)

                commitNowAllowingStateLoss()
            }
        }
    }
}