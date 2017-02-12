package com.example.nut.trainingmvp.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by nut on 2/11/17.
 */
interface StarWarsApi {
    @GET("films/")
    fun getAllFilms(): Call<FilmResponse>

    @GET("films/{id}/")
    fun getFilm(@Path("id") id: Long): Call<Film>
}