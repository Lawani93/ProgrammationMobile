package com.example.pokemonfun.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pokemonfun.R
import com.example.pokemonfun.presentation.Singletons
import com.example.pokemonfun.presentation.api.PokemonDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.pokemon_detail_name)

        callApi()

    }

    private fun callApi() {
        val id:Int = arguments?.getInt("pokemonId") ?: -1

        Singletons.pokemonApi.getPokemonDetail(id).enqueue(object: Callback<PokemonDetailResponse> {
            override fun onResponse(
                call: Call<PokemonDetailResponse>,
                response: Response<PokemonDetailResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.name
                }
            }

            override fun onFailure(
                call: Call<PokemonDetailResponse>,
                t: Throwable
            ) {
                // TODO("Not yet implemented")
            }

        })
    }
}
