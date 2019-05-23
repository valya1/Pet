package com.example.napoleonit.petproject.screens.dogs_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.napoleonit.petproject.base.ui.BindingViewHolder
import com.example.napoleonit.petproject.databinding.DogItemBinding
import com.example.napoleonit.petproject.repository.Dog

class DogsListAdapter : RecyclerView.Adapter<BindingViewHolder<DogItemBinding>>() {

    private val dogs = arrayListOf<Dog>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<DogItemBinding> {
        val binding = DogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BindingViewHolder(binding)
    }

    override fun getItemCount() = dogs.size

    override fun onBindViewHolder(holder: BindingViewHolder<DogItemBinding>, position: Int) {
        holder.binding.dog = dogs[position]
    }
}
