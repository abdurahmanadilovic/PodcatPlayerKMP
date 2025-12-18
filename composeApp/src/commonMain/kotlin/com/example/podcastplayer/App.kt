package com.example.podcastplayer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import com.example.podcastplayer.player.PlayState
import com.example.podcastplayer.player.Playable
import org.jetbrains.compose.resources.painterResource // For multiplatform projects
import org.jetbrains.compose.ui.tooling.preview.Preview

import podcastplayer.composeapp.generated.resources.Res
import podcastplayer.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Box(modifier = Modifier.safeContentPadding()) {
            ListOfPlayable()
        }
    }
}

@Composable
@Preview
fun ListOfPlayable() {
    val list = listOf(
        Playable("Name 1", title = "Tittle 1", "Subtitle 1"),
        Playable("Name 2", title = "Tittle 2", "Subtitle 2"),
        Playable("Name 3", title = "Tittle 3", "Subtitle 3"),
    )
    Column {
        list.map {
            PodcastCell(it)
        }
    }
}

@Composable
@Preview
fun PodcastCell(playable: Playable) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(playable.uri)
        Spacer(Modifier.size(4.dp))
        PlayButton()
    }
}

@Composable
fun PlayButton() {
    Box(modifier = Modifier.height(30.dp).width(80.dp)) {
        Button(
            modifier = Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
            contentPadding = PaddingValues(4.dp),
            onClick = {

            },
            content = { Text("Play", style = MaterialTheme.typography.bodySmall) }
        )
    }
}

@Composable
@Preview
fun PlayerView(currentPlaying: Playable, playState: PlayState) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Text(currentPlaying.title)
        PlayerControls(playState)
    }
}

@Composable
fun PlayerControls(playState: PlayState) {
    Button(onClick = {}) {
        Text(
            when (playState) {
                PlayState.Loading -> "..."
                PlayState.Playing -> "Pause"
                PlayState.Paused -> "Play"
                PlayState.Stopped -> "Play"
            }
        )
    }
}