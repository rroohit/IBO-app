package roh.com.iboapp.domain.repository

import roh.com.iboapp.domain.model.MovieDetails

interface MovieRepository {

    suspend fun getMovieDetails(): List<MovieDetails>
}