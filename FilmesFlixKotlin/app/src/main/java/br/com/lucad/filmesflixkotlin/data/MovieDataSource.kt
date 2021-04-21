package br.com.lucad.filmesflixkotlin.data

import br.com.lucad.filmesflixkotlin.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>

}