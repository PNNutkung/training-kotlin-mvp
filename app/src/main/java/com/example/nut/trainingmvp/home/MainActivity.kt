package com.example.nut.trainingmvp.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.nut.trainingmvp.R
import com.example.nut.trainingmvp.film.FilmActivity
import com.example.nut.trainingmvp.models.Film
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeContract.HomeView {
    val presenter: HomePresenter = HomePresenter(this)
    val filmAdapter = FilmAdapter(null, object : FilmAdapter.OnFilmClickListener {
        override fun onFilmClick(film: Film) {
            presenter.onFilmItemClicked(film)
        }
    })

    override fun showLoading() {
        srl.isRefreshing = true
    }

    override fun hideLoading() {
        srl.isRefreshing = false
    }

    override fun showTitle(title: String) {
        setTitle(title)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }

    override fun showAllFilms(films: List<Film>) {
        filmAdapter.set(films)
    }

    override fun navigateToFilmPage(film: Film) {
        FilmActivity().start(this@MainActivity, film.episodeId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvFilms.layoutManager = LinearLayoutManager(this)
        rvFilms.adapter = filmAdapter
        srl.setOnRefreshListener { presenter.getAllFilms() }
        presenter.getAllFilms()
    }
}
