package br.com.lucad.filmesflixkotlin.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import br.com.lucad.filmesflixkotlin.R
import br.com.lucad.filmesflixkotlin.domain.Movie
import br.com.lucad.filmesflixkotlin.framework.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadVisibility(true)
    }

    private fun initObserver(){
        movieListViewModel.movieList.observe(this, { list ->
            if(list.isNotEmpty()){
                populateList(list)
                loadVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadVisibility(isLoading: Boolean){
        progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE

    }
}