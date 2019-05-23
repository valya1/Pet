package com.example.napoleonit.petproject.tabs.cat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.napoleonit.petproject.R
import com.jakewharton.rxbinding2.view.visibility
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_cats_info.*
import me.dmdev.rxpm.base.PmSupportFragment

class CatInfoFragment : PmSupportFragment<CatPresentationModel>() {

    override fun providePresentationModel() = CatPresentationModel()


    override fun onBindPresentationModel(pm: CatPresentationModel) {

        pm.showTextQueryResults bindTo { textQuery ->
            Toast.makeText(context!!, textQuery, Toast.LENGTH_SHORT).show()
        }

        pm.inProgress bindTo spinner.visibility()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cats_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxTextView.textChanges(tvTextInput).map(CharSequence::toString) bindTo presentationModel.textQuery.consumer

    }

}
