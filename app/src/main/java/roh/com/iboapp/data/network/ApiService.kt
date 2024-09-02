package roh.com.iboapp.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import roh.com.iboapp.domain.model.MovieDetails

interface ApiService {
    // .json?_=1700718031139
    // get list of movies from server

    @GET("json")
    suspend fun getMovies(
        @Path("alldocs") allDocs: String
    ): List<MovieDetails>

}