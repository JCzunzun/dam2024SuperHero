package edu.iesam.dam2024.features.SuperHero.data.remote

import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroMockRemoteDataSource {
    private val superHeros = listOf(
        SuperHero(
            id = "1",
            name = "A-Bomb",
            slug = "1-a-bomb",
            image = "",
        ),
        SuperHero(
            id = "2",
            name = "Abe Sapien",
            slug = "2-abe-sapien",
            image = "",
        ),
        SuperHero(
            id = "3",
            name = "Abin Sur",
            slug = "3-abin-sur",
            image = "",
        )
    )

    fun getSupersHeros(): List<SuperHero> {
        return superHeros

    }

    fun getSuperHero(superHeroID: String): SuperHero? {
        return superHeros.firstOrNull { superHerp ->
            superHerp.id == superHeroID
        }
    }
}