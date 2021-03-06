package com.example.napoleonit.petproject.root

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.tabs.cat.CatScreen
import com.example.napoleonit.petproject.tabs.dog.DogScreen
import dagger.Lazy
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_layout.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class RootActivity : MvpAppCompatActivity(), RootView {

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    @InjectPresenter
    lateinit var rootPresenter: RootPresenter

    @Inject
    lateinit var presenterProvider: Lazy<RootPresenter>

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()


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

        override fun fragmentForward(command: Forward) {

            val currentTab = supportFragmentManager.findFragmentById(R.id.mainContainer)
            val newTab = supportFragmentManager?.findFragmentByTag(command.screen.screenKey)
                ?: (command.screen as? SupportAppScreen)?.fragment

            if (newTab != null && currentTab != newTab) {

                supportFragmentManager.beginTransaction().apply {
                    if (currentTab?.isAdded == true)
                        hide(currentTab)
                    if (!newTab.isAdded)
                        add(R.id.mainContainer, newTab, command.screen.screenKey)
                    show(newTab)

                    commitNowAllowingStateLoss()
                }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

//        rootPresenter.goTo(DogScreen())

//        createNavigationHolderDialogFragment()

        bottomNavigationView.setOnNavigationItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dog -> {
                    rootPresenter.goTo(DogScreen())
                }
                R.id.cat -> {
                    rootPresenter.goTo(CatScreen())
                }
            }
        }



//        floatActionButton.setImagesFloatingAnimation(
//            listOf(
//                { ResourcesCompat.getDrawable(resources, R.drawable.gift, null) },
//                { ResourcesCompat.getDrawable(resources, R.drawable.lab_puppy_hero, null) }
//            )

    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }


    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }


//    fun createNavigationHolderDialogFragment() {
//
//
//        TestContainerDialogFragment().show(supportFragmentManager, "test")
//
//    }
}