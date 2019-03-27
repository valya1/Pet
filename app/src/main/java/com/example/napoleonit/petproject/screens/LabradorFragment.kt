package com.example.napoleonit.petproject.screens

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.base.mvp.BaseFragment
import dagger.Lazy
import javax.inject.Inject

class LabradorFragment : BaseFragment(), LabradorView {

    @InjectPresenter
    lateinit var labradorPresenter: LabradorPresenter

    @Inject
    lateinit var presenterProvider: Lazy<LabradorPresenter>

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()


    override fun getLayoutId(): Int = R.layout.labrador_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}