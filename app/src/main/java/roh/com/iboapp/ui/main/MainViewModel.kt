package roh.com.iboapp.ui.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import roh.com.iboapp.di.module.NetworkModule
import roh.com.iboapp.domain.model.MovieDetails
import roh.com.iboapp.domain.repository.MovieRepository
import roh.com.iboapp.ui.home.HomeUiState
import javax.inject.Inject

private const val TAG = "MAIN_VM"

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails

    init {
        fetchListOfMoviesFromServer()
    }

    // fun to fetch list and update in state
    fun fetchListOfMoviesFromServer() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = HomeUiState.Loading

            try {
                val listOfMovies = movieRepository.getMovieDetails()
                Log.d(TAG, "ListOfMoviesFromServer: $listOfMovies ")
                _uiState.value = HomeUiState.Success(listOfMovies)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error
                Log.e(TAG, "fetchListOfMoviesFromServer: ", e)
            }

        }
    }

    fun onMovieSelected(movieDetails: MovieDetails) {
        viewModelScope.launch {
            _movieDetails.value = movieDetails
        }
    }

}