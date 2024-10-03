package edu.iesam.dam2024.features.SuperHero.presentation.adapter

import android.view.View

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extension.loadImage
import edu.iesam.dam2024.databinding.ItemSuperheroBinding
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroViewHolder (val view: View):RecyclerView.ViewHolder(view){
    val itemSuperHero = ItemSuperheroBinding.bind(view)
    fun bind(superHero: SuperHero, onClick :(String) -> Unit){
        itemSuperHero.apply {
            superId.loadImage(superHero.images.md)
            supRName.text = superHero.name
            superAlias.text = superHero.slug
            view.setOnClickListener{
                onClick(superHero.id.toString())
            }
        }
    }
}