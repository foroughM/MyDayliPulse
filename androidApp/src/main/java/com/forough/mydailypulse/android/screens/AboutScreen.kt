package com.forough.mydailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.forough.mydailypulse.Platform

@Composable
fun AboutScreen(onClick: () -> Unit) {
    Column {
        Toolbar(onClick)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(onClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "About Device")
        },
        actions = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "close about screen"
                )
            }
        }
    )
}

@Composable
fun ContentView() {
    val items = makeItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) { item ->
            RowView(title = item.first, subtitle = item.second)
        }
    }
}

@Composable
fun RowView(title: String, subtitle: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
    Divider()
}

fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()

    return listOf(
        Pair("Operating system", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}
