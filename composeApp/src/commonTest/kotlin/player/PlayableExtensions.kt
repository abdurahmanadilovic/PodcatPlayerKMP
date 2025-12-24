package player

import com.example.podcastplayer.player.Playable
import com.example.podcastplayer.player.Playable.Companion

fun Companion.instance(index: Int): Playable {
    return Playable("uri $index", "Title $index", "Subtitle $index")
}