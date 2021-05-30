package com.example.pokemonfun.presentation.api

data class PokemonDetailResponse (
    val name: String,
    val types: List<PokemonSlot>
)

data class PokemonSlot (
    val slot: Int,
    val type: List<PokemonType>
)

data class PokemonType (
    val name: String,
    val url: String
)
