package roh.com.iboapp.ui.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import roh.com.iboapp.di.module.NetworkModule
import roh.com.iboapp.domain.model.MovieDetails
import javax.inject.Inject

private const val TAG = "MAIN_VM"

@HiltViewModel
class MainViewModel
@Inject
constructor(

) : ViewModel() {

    val movies: MutableState<List<MovieDetails>> = mutableStateOf(emptyList())


    init {
        fetchListOfMoviesFromServer()
    }

    // state for list observer

    // fun to fetch list and update in state
    fun fetchListOfMoviesFromServer() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val apiService = NetworkModule.api
                val movieList = apiService.getMovies("1700718031139")
                Log.d(TAG, "fetchListOfMoviesFromServer: $movieList")

                if (movieList.isNotEmpty()) {
                    movies.value = movieList
                }
            } catch (e: Exception) {
                Log.e(TAG, "fetchListOfMoviesFromServer: exception", e)
            }

        }
    }

}