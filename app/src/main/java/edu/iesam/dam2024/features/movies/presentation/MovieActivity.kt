package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.local.MovieXMLLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    val xmlDataSource = MovieXMLLocalDataSource(this)

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()
        val movies = viewModel.viewCreated()
        bindDate(movies)

        Log.d("@dev", movies.toString())
        // testXml()
        testListXml()
        val moviesFromXml = xmlDataSource.findAll()
        Log.d("@dev", moviesFromXml.toString())

    }

    private fun testXml() {

        val movie = viewModel.itemSelected("1")
        movie?.let {
            xmlDataSource.save(it)
        }
        val movieSaved = xmlDataSource.find()
        Log.d("@dev", movieSaved.toString())

        xmlDataSource.delete()

    }

    private fun testListXml() {
        val movies = viewModel.viewCreated()
        val xmlDataSource = MovieXMLLocalDataSource(this)
        xmlDataSource.saveAll(movies)
    }

    private fun bindDate(movies: List<Movie>) {
            findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
            findViewById<TextView>(R.id.movie_tittle_1).text = movies[0].title
            findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
                val movie1: Movie? = viewModel.itemSelected(movies[0].id)
                movie1?.let {
                    Log.d("@dev", "Pelicula seleccionada: ${it.title}")
                }
            }
            findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
            findViewById<TextView>(R.id.movie_tittle_2).text = movies[1].title

            findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
            findViewById<TextView>(R.id.movie_tittle_3).text = movies[2].title



        }


}