package com.example.filmnet.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.filmnet.ui.model.VideoEntity
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val homeUiSate = viewModel.homeUiState.collectAsState()
    var query by remember { mutableStateOf("") }

    val isLoading = homeUiSate.value.isLoading
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            HomeSearchTextField(onChangedQuery = {
                query = it
            }, query = query)
            HomeSearchSubmitButton {
                viewModel.searchVideo(query)
            }
        }

        if (isLoading) {
            HomeListLoading()
        }

        if (homeUiSate.value.isEmptyList) {
            HomeEmptyList()
        } else {
            HomeVideoList(homeUiSate.value.videoList)
        }
    }
}

@Composable
fun HomeSearchTextField(
    modifier: Modifier = Modifier,
    query: String = "",
    onChangedQuery: (String) -> (Unit)
) {
    TextField(
        value = query,
        onValueChange = { onChangedQuery(it) },
        placeholder = { Text(text = "Search Video...") },
        modifier = modifier
    )
}

@Composable
fun HomeSearchSubmitButton(modifier: Modifier = Modifier, onSearchEvent: () -> (Unit)) {
    Button(modifier = modifier, onClick = { onSearchEvent() }) {
        Text(text = "Search Video")
    }
}

@Composable
fun HomeVideoList(videoList: List<VideoEntity> = emptyList()) {
    LazyColumn() {
        items(items = videoList) {
            VideoCard(videoEntity = it)
        }
    }
}

@Composable
fun HomeEmptyList(modifier: Modifier = Modifier) {
    Text(text = "List is Empty", modifier = modifier.height(100.dp))
}

@Composable
fun VideoCard(videoEntity: VideoEntity, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Text(text = videoEntity.title, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = videoEntity.description, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${videoEntity.year}", color = Color.White)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "${videoEntity.rate}", color = Color.White)
    }
}

@Composable
fun HomeListLoading() {
    CircularProgressIndicator()
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}