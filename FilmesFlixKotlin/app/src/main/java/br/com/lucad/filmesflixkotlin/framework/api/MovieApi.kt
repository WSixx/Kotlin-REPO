package br.com.lucad.filmesflixkotlin.framework.api

import br.com.lucad.filmesflixkotlin.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}