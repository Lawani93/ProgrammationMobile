package com.example.pokemonfun.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<PokemonDetailResponse>
}