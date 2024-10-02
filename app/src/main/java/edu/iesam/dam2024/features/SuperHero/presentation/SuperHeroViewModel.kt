package edu.iesam.dam2024.features.SuperHero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHerosUseCase
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroViewModel(
    private val getSuperHerosUseCase: GetSuperHerosUseCase,
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {
    fun viewCreated(): List<SuperHero> {
        return getSuperHerosUseCase.invoke()
    }

    fun itemSelected(superHeroId: String): SuperHero? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}