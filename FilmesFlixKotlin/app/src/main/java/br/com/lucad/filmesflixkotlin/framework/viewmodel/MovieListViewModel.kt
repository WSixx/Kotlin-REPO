package br.com.lucad.filmesflixkotlin.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lucad.filmesflixkotlin.framework.api.MovieRestApiTask
import br.com.lucad.filmesflixkotlin.data.MovieRepository
import br.com.lucad.filmesflixkotlin.domain.Movie
import br.com.lucad.filmesflixkotlin.implemetation.MovieDataSourceImplementation
import br.com.lucad.filmesflixkotlin.usecase.MovieListUseCase
import java.lang.Exception

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUSeCase = MovieListUseCase(movieRepository)


    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList


    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        Thread{
            try {
                _movieList.postValue(movieListUSeCase.invoke())
            }catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }
}