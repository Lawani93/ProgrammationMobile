package com.example.pokemonfun.presentation

import com.example.pokemonfun.presentation.PokemonApplication.Companion.context
import com.example.pokemonfun.presentation.api.PokemonApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object {
        var cache: Cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val pokemonApi: PokemonApi = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
            .create(PokemonApi::class.java)

    }
}