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
    fun playerSetsPlayingState() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable("123")))

        assertEquals(PlayState.Playing, kmpPlayer.getState())
    }

    @Test
    fun playerKeepsCurrentPlayingEpisode() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable("123")))

        assertEquals(1, kmpPlayer.getCurrentPlaylist().size)
    }

    @Test
    fun playerCanPlayNext() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable("1"), Playable("2")))
        kmpPlayer.playNext()

        assertEquals("2", kmpPlayer.getCurrentlyPlaying().uri)
    }

    @Test
    fun playerCanPlayNextIfPossible() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable("1"), Playable("2")))
        kmpPlayer.playNext()
        kmpPlayer.playNext()
        kmpPlayer.playNext()

        assertEquals("2", kmpPlayer.getCurrentlyPlaying().uri)
    }
}