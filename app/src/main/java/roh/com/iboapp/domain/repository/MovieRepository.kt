package roh.com.iboapp.domain.repository

interface MovieRepository {

    // get list of movies from server
    suspend fun getMovies()
}