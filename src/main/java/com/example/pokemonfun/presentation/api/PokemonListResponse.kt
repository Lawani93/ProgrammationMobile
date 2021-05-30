package com.example.pokemonfun.presentation.api

import com.example.pokemonfun.presentation.list.Pokemon

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val results: List<Pokemon>
)