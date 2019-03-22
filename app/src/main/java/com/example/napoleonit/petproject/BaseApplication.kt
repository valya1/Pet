package com.example.napoleonit.petproject

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.napoleonit.petproject.di.Injector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class BaseApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingFragmentInjector

    override fun activityInjector() = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()

        Injector.initWithApp(this)

    }
}