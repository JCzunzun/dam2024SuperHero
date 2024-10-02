package edu.iesam.dam2024.features.SuperHero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {
    fun viewCreated(superHeroId: String): SuperHero? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}
