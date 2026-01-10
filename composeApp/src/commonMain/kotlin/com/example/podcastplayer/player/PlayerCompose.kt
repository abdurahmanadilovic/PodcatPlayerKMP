package com.example.podcastplayer.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

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
            PodcastCell(it, playState = PlayState.Playing)
        }
    }
}

@Preview
@Composable
fun PodcastCellPreview() {
    PodcastCell(Playable("uri", "title", "subtitle"), PlayState.Paused)
}

@Composable
fun PodcastCell(playable: Playable, playState: PlayState) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(playable.title)
        Spacer(Modifier.size(4.dp))
        PlayButton(playState)
    }
}

@Composable
fun PlayButton(playState: PlayState) {
    Box(modifier = Modifier.height(30.dp).width(80.dp)) {
        Button(
            modifier = Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
            contentPadding = PaddingValues(4.dp),
            onClick = {

            },
            content = { PlayerControls(playState) }
        )
    }
}

@Composable
fun PlayerView(currentPlaying: Playable, playState: PlayState) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(currentPlaying.title, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.width(8.dp))
        PlayButton(playState)
    }
}

@Preview
@Composable
fun PlayerViewPreview() {
    PlayerView(
        Playable("uri", "title", "subtitle"),
        playState = PlayState.Stopped
    )
}

@Composable
fun PlayerControls(playState: PlayState) {
    Text(
        when (playState) {
            PlayState.Loading -> "..."
            PlayState.Playing -> "Pause"
            PlayState.Paused -> "Play"
            PlayState.Stopped -> "Play"
        }
    )
}
