package br.com.lucad.filmesflixkotlin.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lucad.filmesflixkotlin.model.Movie

class ModelListViewModel: ViewModel() {

    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            titulo = "Titanic",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),

        Movie(
            id = 1,
            titulo = "Iluminado",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),
    )

    private

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){

    }
}