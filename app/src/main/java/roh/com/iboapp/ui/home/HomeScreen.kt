package roh.com.iboapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    val listOfMovies by viewModel.movies

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Fixed(4)
    ) {
        items(listOfMovies) { item: MovieDetails ->
            ImageItem(item) {
                onItemClick(item)
            }
        }
    }

}

@Composable
fun ImageItem(
    movieDetails: MovieDetails,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        // Image view add with coil
        AsyncImage(
            model ="${movieDetails.image_portrait}",
            contentDescription = null,
        )

        Text(text = "Movie Name - ${movieDetails.title}")
    }
}

@Preview
@Composable
fun ImageItem() {
    Column(
        modifier = Modifier.height(200.dp).clickable {
            // onItemClick()
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image view add with coil
        AsyncImage(
            model ="https://occ-0-2101-185.1.nflxso.net/dnm/api/v6/evlCitJPPCVCry0BZlEFb5-QjKc/AAAABUGROZVFdFvFOcMoTKXOr7RI3yoiqFuSiS6AeEaTKABUf_UOgkcIdDvpWK2jizE6qkoDa05ITv2L-HI-CimelEJ8id5R.jpg?r=e9e",
            contentDescription = null,
        )

        Text(text = "Jerry Seinfeld: Comedian")
    }
}
