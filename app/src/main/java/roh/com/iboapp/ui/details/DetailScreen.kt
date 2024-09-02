package roh.com.iboapp.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import roh.com.iboapp.domain.model.MovieDetails

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    movieDetails: MovieDetails? = null
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Image view add with coil
        // AsyncImage()

        Text(text = "Movie Name - ${movieDetails?.title}")

        Text(text = "Movie Description - ${movieDetails?.title}")
    }
}