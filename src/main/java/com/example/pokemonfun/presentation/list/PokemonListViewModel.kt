package com.example.pokemonfun.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonfun.presentation.Singletons
import com.example.pokemonfun.presentation.api.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListViewModel : ViewModel() {
    val pokemonList : MutableLiveData<PokemonModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokemonList.value = PokemonLoader

        Singletons.pokemonApi.getPokemonList().enqueue(object: Callback<PokemonListResponse> {

            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val pokemonResponse : PokemonListResponse = response.body()!!
                    pokemonList.value = PokemonSuccess(pokemonResponse.results)
                } else {
                    pokemonList.value = PokemonError
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                pokemonList.value = PokemonError
            }
        })
    }
}