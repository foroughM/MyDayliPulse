package com.forough.mydailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.forough.mydailypulse.article.application.Article
import com.forough.mydailypulse.article.presentation.ArticlesViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import org.koin.androidx.compose.koinViewModel


@Composable
fun ArticlesScreen(
    viewModel: ArticlesViewModel = koinViewModel(),
    onInfoClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    val articlesState = viewModel.articlesState.collectAsState()

    Column {
        AppBar(onInfoClick = onInfoClick, onMenuClick = onMenuClick)
        if (articlesState.value.error != null) {
            ErrorMessage(articlesState.value.error!!)
        } else if (articlesState.value.articles.isNotEmpty()) {
            ArticlesListView(viewModel)
        }
    }

}

@Composable
fun ArticlesListView(viewModel: ArticlesViewModel) {
    SwipeRefresh(state = SwipeRefreshState(viewModel.articlesState.value.isLoading),
        onRefresh = {
            viewModel.getArticles(true)
        }) {
        LazyColumn {
            items(viewModel.articlesState.value.articles) { article ->
                ArticleItemView(article)
            }
        }
    }
}

@Composable
fun ArticleItemView(article: Article) {
    AsyncImage(
        model = article.imageUrl,
        contentDescription = null
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = article.title,
        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = article.desc)
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = article.date,
        style = TextStyle(color = Color.Gray),
        textAlign = TextAlign.End
    )
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun ErrorMessage(errorMessage: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onInfoClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    TopAppBar({
        Text(text = "Articles")
    },
        actions = {
            Row {
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "source screen"
                    )
                }
                IconButton(onClick = onInfoClick) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "about screen"
                    )
                }
            }
        })
}
