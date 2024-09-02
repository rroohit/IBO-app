package roh.com.iboapp.di.bind

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import roh.com.iboapp.data.impl.MovieRepositoryImpl
import roh.com.iboapp.domain.repository.MovieRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBind {

    @Singleton
    @Binds
    abstract fun bindApiService(
        analyticsServiceImpl: MovieRepositoryImpl
    ): MovieRepository

}