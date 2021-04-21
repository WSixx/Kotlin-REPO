package br.com.lucad.filmesflixkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lucad.filmesflixkotlin.model.Movie
import br.com.lucad.filmesflixkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateList()
    }

    private fun populateList(){
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(listOfMovies)
        }
    }
}