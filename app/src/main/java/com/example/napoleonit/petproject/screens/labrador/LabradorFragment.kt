package com.example.napoleonit.petproject.screens.labrador

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.base.ui.ScreenFragment
import dagger.Lazy
import kotlinx.android.synthetic.main.labrador_fragment.*
import javax.inject.Inject

class LabradorFragment : ScreenFragment(), LabradorView {


    @InjectPresenter
    lateinit var labradorPresenter: LabradorPresenter

    @Inject
    lateinit var presenterProvider: Lazy<LabradorPresenter>

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val brightness = 230.0f / 255.0f
//        val lp = activity?.window?.attributes
//        lp?.screenBrightness = brightness
//        activity?.window?.attributes = lp
    }

    override fun getLayoutId(): Int = R.layout.labrador_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnDontShowAgain.setOnClickListener {
            parentFragment?.childFragmentManager?.beginTransaction()?.apply {
                remove(this@LabradorFragment)
                commitAllowingStateLoss()
            }
        }
    }

}