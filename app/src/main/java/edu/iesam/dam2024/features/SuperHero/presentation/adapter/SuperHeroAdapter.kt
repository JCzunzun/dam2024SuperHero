package edu.iesam.dam2024.features.SuperHero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero
import edu.iesam.dam2024.features.SuperHero.presentation.SuperHeroDiffUtil

class SuperHeroAdapter :ListAdapter<SuperHero,SuperHeroViewHolder>(SuperHeroDiffUtil()){

    lateinit var onClick:(superHeroID:String) ->Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superhero, parent,false)
        return SuperHeroViewHolder(layoutInflater)
    }



    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {

        holder.bind(currentList[position], onClick)
    }

}