package com.example.pokemonfun.presentation

import android.app.Application
import android.content.Context

class PokemonApplication : Application() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}