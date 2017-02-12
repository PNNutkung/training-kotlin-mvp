package com.example.nut.trainingmvp.film

import com.example.nut.trainingmvp.models.Apis
import com.example.nut.trainingmvp.models.Film
import com.example.nut.trainingmvp.models.StarWarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmPresenter(val view: FilmContract.FilmView, val id: Long): FilmContract.FilmPresenter {
    val starWarsApi: StarWarsApi = Apis().getStarWarsApi()

    override fun getFilm() {
        view.showLoading()
        starWarsApi.getFilm(id).enqueue(object : Callback<Film> {
            override fun onFailure(call: Call<Film>?, t: Throwable?) {
                view.showMessage(t!!.message!!)
                view.hideLoading()
            }

            override fun onResponse(call: Call<Film>?, response: Response<Film>?) {
                val film: Film = response!!.body()
                view.showTitle(film.title)
                view.showReleaseDate(film.releaseDate)
                view.showDirector(film.director)
                view.showCrawl(film.openingCrawl)
                view.hideLoading()
            }

        })
    }

}
