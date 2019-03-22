package com.example.napoleonit.petproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.main_layout.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class RootActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navigationHolder: NavigatorHolder


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


        bottomNavigationView.setOnNavigationItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dog -> {
                }

                R.id.cat -> {

                }
            }
        }

    }
}