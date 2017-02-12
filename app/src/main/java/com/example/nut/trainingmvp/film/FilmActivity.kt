package com.example.nut.trainingmvp.film

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.nut.trainingmvp.R
import kotlinx.android.synthetic.main.activity_film.*

class FilmActivity : AppCompatActivity(), FilmContract.FilmView {

    private val KEY_FILM_ID: String = "FILM_ID"
    lateinit var presenter: FilmPresenter

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showTitle(title: String) {
        setTitle(title)
    }

    override fun showReleaseDate(dateString: String) {
        tvReleaseDate.text = dateString
    }

    override fun showDirector(director: String) {
        tvDirector.text = director
    }

    override fun showCrawl(crawl: String) {
        tvCrawl.text = crawl
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        val episodeId: Long = intent.getLongExtra(KEY_FILM_ID, 0)
        presenter = FilmPresenter(this, episodeId)
        presenter.getFilm()
    }

    fun start(context: Context, episodeId: Long) {
        val starter: Intent = Intent(context, FilmActivity::class.java)
        starter.putExtra(KEY_FILM_ID, episodeId)
        context.startActivity(starter)
    }
}
