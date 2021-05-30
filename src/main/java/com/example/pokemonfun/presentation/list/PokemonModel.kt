package com.example.pokemonfun.presentation.list

sealed class PokemonModel

data class PokemonSuccess(val pokemonList: List<Pokemon>) : PokemonModel()
object PokemonLoader : PokemonModel()
object PokemonError : PokemonModel()