package edu.iesam.dam2024.features.SuperHero.data

import edu.iesam.dam2024.features.SuperHero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero
import edu.iesam.dam2024.features.SuperHero.domain.SuperHeroRepository

class SuperHeroDataRepository(private val mockRemoteDataSource: SuperHeroMockRemoteDataSource) :
    SuperHeroRepository {
    override fun getSuperHeros(): List<SuperHero> {
        return mockRemoteDataSource.getSupersHeros()
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        return mockRemoteDataSource.getSuperHero(superHeroId)
    }

}