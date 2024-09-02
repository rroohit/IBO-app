package roh.com.iboapp.data.impl

import roh.com.iboapp.data.network.ApiService
import roh.com.iboapp.domain.model.MovieDetails
import roh.com.iboapp.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl
@Inject
constructor(
    private val api: ApiService
): MovieRepository {

    override suspend fun getMovieDetails(): List<MovieDetails> {
        return api.getMovieDetails()
    }

}