package com.example.napoleonit.petproject.screens.dogs_list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.napoleonit.petproject.R
import com.example.napoleonit.petproject.base.ui.ScreenFragment
import kotlinx.android.synthetic.main.dogs_info_layout.*

class DogsListFragment : ScreenFragment() {

    override fun getLayoutId() = R.layout.dogs_info_layout


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lm = LinearLayoutManager(view.context)

        rvDogsList.layoutManager = lm
        rvDogsList.adapter = DogsListAdapter()





    }


}