package edu.iesam.dam2024.features.SuperHero.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroDiffUtil : DiffUtil.ItemCallback<SuperHero>() {
    override fun areItemsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem == newItem
    }
}