package com.forough.mydailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.forough.mydailypulse.source.application.Source
import com.forough.mydailypulse.source.presentation.SourceViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SourcesScreen(
    viewModel: SourceViewModel = koinViewModel()
) {

    val sourcesState = viewModel.sourcesState.collectAsState()

    when {
        sourcesState.value.isLoading -> {
            Loader()
        }

        sourcesState.value.sources.isNotEmpty() -> {
            SourcesListView(sourcesState.value.sources)
        }

        sourcesState.value.error != null -> {
            ErrorMessage(errorMessage = sourcesState.value.error!!)
        }
    }

}

@Composable
fun SourcesListView(sources: List<Source>) {
    LazyColumn {
        items(sources) { item ->
            sourceItemView(item)
        }
    }
}

@Composable
fun sourceItemView(source: Source) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.desc ?: "")
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${source.country}-${source.language}",
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}