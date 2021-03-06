package com.example.nut.trainingmvp.home

import com.example.nut.trainingmvp.models.Apis
import com.example.nut.trainingmvp.models.Film
import com.example.nut.trainingmvp.models.FilmResponse
import com.example.nut.trainingmvp.models.StarWarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val view: HomeContract.HomeView): HomeContract.HomePresenter {
    var starWarsApi: StarWarsApi = Apis().getStarWarsApi()

    init {
        view.showTitle("All Star Wars Films")
    }

    override fun getAllFilms() {
        view.showLoading()
        starWarsApi.getAllFilms().enqueue(object : Callback<FilmResponse> {
            override fun onResponse(call: Call<FilmResponse>?, response: Response<FilmResponse>?) {
                view.showAllFilms(response!!.body().results)
                view.hideLoading()
            }

            override fun onFailure(call: Call<FilmResponse>?, t: Throwable?) {
                view.showMessage(t?.message!!)
                view.hideLoading()
            }
        })
    }

    override fun onFilmItemClicked(film: Film) {
        view.navigateToFilmPage(film)
    }

}