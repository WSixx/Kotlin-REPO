package br.com.lucad.filmesflixkotlin.usecase

import br.com.lucad.filmesflixkotlin.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMovieFromDataSource()

}