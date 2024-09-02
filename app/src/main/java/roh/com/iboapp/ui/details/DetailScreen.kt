package roh.com.iboapp.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import roh.com.iboapp.ui.main.MainViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {

    val movieDetails by viewModel.movieDetails.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (movieDetails != null) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(12.dp)),
                model = movieDetails?.image_portrait,
                contentDescription = "Movie Poster",
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Movie Name - ${movieDetails?.title}")

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Movie Description - ${movieDetails?.description}")
        } else {
            Text("Movie details not found")
        }
    }
}