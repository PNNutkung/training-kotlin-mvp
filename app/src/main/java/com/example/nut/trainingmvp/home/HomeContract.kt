package com.example.nut.trainingmvp.home

import com.example.nut.trainingmvp.models.Film

/**
 * Created by nut on 2/11/17.
 */
interface HomeContract {
    interface HomeView {
        fun showLoading()
        fun hideLoading()
        fun showTitle(title: String)
        fun showMessage(message: String)
        fun showAllFilms(films: List<Film>)
        fun navigateToFilmPage(film: Film)
    }

    interface HomePresenter {
        fun getAllFilms()
        fun onFilmItemClicked(film: Film)
    }
}