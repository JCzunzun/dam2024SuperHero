package edu.iesam.dam2024.features.SuperHero.presentation

import android.content.Context
import edu.iesam.dam2024.features.SuperHero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.SuperHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.SuperHero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHerosUseCase

class SuperHeroFactory(context: Context) {
    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository =
        SuperHeroDataRepository(superHeroLocal, superHeroMockRemoteDataSource)
    private val getSuperHerosUseCase = GetSuperHerosUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            getSuperHerosUseCase, getSuperHeroUseCase
        )
    }

    fun buildSuperHeroDetailViewMovie(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }
}