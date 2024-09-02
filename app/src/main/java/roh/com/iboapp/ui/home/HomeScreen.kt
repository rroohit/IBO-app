package roh.com.iboapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import roh.com.iboapp.domain.model.MovieDetails
import roh.com.iboapp.ui.main.MainViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(),
    onItemClick: (MovieDetails) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()


    when (uiState) {
        HomeUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is HomeUiState.Success -> {
            LazyVerticalGrid(
                modifier = modifier.fillMaxWidth(),
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(8.dp)
            ) {
                val listOfMovies = (uiState as HomeUiState.Success).movies
                items(listOfMovies) { item: MovieDetails ->
                    ImageItem(item) {
                        onItemClick(item)
                    }
                }
            }
        }

        HomeUiState.Error -> {
            Text("Error loading movies")
        }

    }

}

@Composable
fun ImageItem(
    movieDetails: MovieDetails,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(3.dp)
            .clip(shape = RoundedCornerShape(4.dp))
            .clickable {
                onItemClick()
            }
    ) {
        // Image view add with coil
        AsyncImage(
            model = movieDetails.image_landscape,
            contentDescription = "Movie Poster",
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = movieDetails.title)
    }
}

@Preview
@Composable
fun ImageItem() {
    Column(
        modifier = Modifier
            .height(200.dp)
            .clickable {
                // onItemClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image view add with coil
        AsyncImage(
            model = "https://occ-0-2101-185.1.nflxso.net/dnm/api/v6/evlCitJPPCVCry0BZlEFb5-QjKc/AAAABUGROZVFdFvFOcMoTKXOr7RI3yoiqFuSiS6AeEaTKABUf_UOgkcIdDvpWK2jizE6qkoDa05ITv2L-HI-CimelEJ8id5R.jpg?r=e9e",
            contentDescription = null,
        )

        Text(text = "Jerry Seinfeld: Comedian")
    }
}
