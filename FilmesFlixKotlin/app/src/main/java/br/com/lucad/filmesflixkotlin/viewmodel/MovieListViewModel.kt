package br.com.lucad.filmesflixkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lucad.filmesflixkotlin.model.Movie

class MovieListViewModel: ViewModel() {

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

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
    get() = _movieList
    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        _movieList.value = listOfMovies
    }
}