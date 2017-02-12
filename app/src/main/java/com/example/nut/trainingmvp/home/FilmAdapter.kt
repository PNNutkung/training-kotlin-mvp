package com.example.nut.trainingmvp.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nut.trainingmvp.R
import com.example.nut.trainingmvp.models.Film
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter (var films: List<Film>, val onFilmClickListener: OnFilmClickListener): RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        val item: Film = films[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return FilmHolder(view, onFilmClickListener)
    }

    override fun getItemCount(): Int {
       return films.size
    }

    fun set(films: List<Film>) {
        this.films = films
        notifyDataSetChanged()
    }

    inner class FilmHolder(itemView: View, val onFilmClickListener: OnFilmClickListener) : RecyclerView.ViewHolder(itemView) {

        fun bind(film: Film) = with(itemView) {
            filmTitle.text = film.title
            super.itemView.setOnClickListener { onFilmClickListener.onFilmClick(film) }
        }

    }

    interface OnFilmClickListener {
        fun onFilmClick(film: Film)
    }
}

