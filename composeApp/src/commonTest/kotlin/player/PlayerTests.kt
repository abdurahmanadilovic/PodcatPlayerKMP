package player

import com.example.podcastplayer.player.KMPPlayer
import com.example.podcastplayer.player.KMPPlayerImpl
import com.example.podcastplayer.player.PlayState
import com.example.podcastplayer.player.Playable
import kotlin.test.Test
import kotlin.test.assertEquals


class PlayerTests {

    @Test
    fun playerSetsPlayingState() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable.instance(123)))

        assertEquals(PlayState.Playing, kmpPlayer.getState())
    }

    @Test
    fun playerKeepsCurrentPlayingEpisode() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable.instance(123)))

        assertEquals(1, kmpPlayer.getCurrentPlaylist().size)
    }

    @Test
    fun playerCanPlayNext() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable.instance(1), Playable.instance(2)))
        kmpPlayer.playNext()

        assertEquals("uri 2", kmpPlayer.getCurrentlyPlaying().uri)
    }

    @Test
    fun playerCanPlayNextIfPossible() {
        val kmpPlayer: KMPPlayer = KMPPlayerImpl()
        kmpPlayer.play(listOf(Playable.instance(1), Playable.instance(2)))
        kmpPlayer.playNext()
        kmpPlayer.playNext()
        kmpPlayer.playNext()

        assertEquals("uri 2", kmpPlayer.getCurrentlyPlaying().uri)
    }
}