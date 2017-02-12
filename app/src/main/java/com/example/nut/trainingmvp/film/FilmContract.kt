package com.example.nut.trainingmvp.film

/**
 * Created by nut on 2/12/17.
 */
interface FilmContract {
    interface FilmView {
        fun showLoading()

        fun hideLoading()

        fun showMessage(message: String)

        fun showTitle(title: String)

        fun showReleaseDate(dateString: String)

        fun showDirector(director: String)

        fun showCrawl(crawl: String)
    }

    interface FilmPresenter {
        fun getFilm()
    }
}
