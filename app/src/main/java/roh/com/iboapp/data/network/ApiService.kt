package roh.com.iboapp.data.network

import retrofit2.http.GET
import roh.com.iboapp.domain.model.MovieDetails

interface ApiService {

    @GET("alldocs.json")
    suspend fun getMovieDetails(): List<MovieDetails>

}