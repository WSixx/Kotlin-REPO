package br.com.lucad.filmesflixkotlin.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMovieFromDataSource() = movieDataSource.getAllMovies()

}