package br.com.lucad.filmesflixkotlin.api

import br.com.lucad.filmesflixkotlin.model.Movie
import retrofit2.http.GET

interface MovieApi {
    
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): List<Movie>

}