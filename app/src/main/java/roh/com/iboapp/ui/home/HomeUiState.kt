package roh.com.iboapp.ui.home

import roh.com.iboapp.domain.model.MovieDetails

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(val movies: List<MovieDetails>) : HomeUiState()
    data object Error : HomeUiState()
}