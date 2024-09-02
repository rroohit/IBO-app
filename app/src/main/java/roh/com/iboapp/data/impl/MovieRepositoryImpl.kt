package roh.com.iboapp.data.impl

import dagger.hilt.android.components.ViewModelComponent
import roh.com.iboapp.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton // may required to provide lifecycle component
class MovieRepositoryImpl
@Inject
constructor(
    // provide api service

): MovieRepository {

    // call api
    override suspend fun getMovies() {
        TODO("Not yet implemented")
    }
}