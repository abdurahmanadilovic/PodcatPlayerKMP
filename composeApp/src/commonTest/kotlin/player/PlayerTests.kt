package player

import com.example.podcastplayer.player.KMPPlayer
import com.example.podcastplayer.player.KMPPlayerImpl
import com.example.podcastplayer.player.PlayState
import com.example.podcastplayer.player.Playable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class PlayerTests {

    @Test
    fun playerCanPlay() {
        val kmpPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable("123")))

        assertEquals(PlayState.Playing, kmpPlayer.getState())
    }
}