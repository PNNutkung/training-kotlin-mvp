package com.example.nut.trainingmvp.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nut.trainingmvp.models.Film
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter (var films: List<Film>?, val onFilmClickListener: OnFilmClickListener): RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        val item: Film? = films!![position]
        holder.film = item!!
        holder.title.text = item.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        return FilmHolder(parent, onFilmClickListener)
    }

    override fun getItemCount(): Int {
       return films?.size ?: 0
    }

    fun set(films: List<Film>?) {
        this.films = films
        notifyDataSetChanged()
    }

    inner class FilmHolder(itemView: View, onFilmClickListener: OnFilmClickListener) : RecyclerView.ViewHolder(itemView) {
        lateinit var film: Film
        lateinit var title: TextView

        init {
            itemView.tvTitle.setOnClickListener { view -> onFilmClickListener.onFilmClick(film) }
        }
    }

    interface OnFilmClickListener {
        fun onFilmClick(film: Film)
    }
}

