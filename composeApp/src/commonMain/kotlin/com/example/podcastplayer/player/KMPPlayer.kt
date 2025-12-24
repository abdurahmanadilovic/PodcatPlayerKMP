package com.example.podcastplayer.player

data class Playable(val uri: String, val title: String, val subtitle: String) {
    companion object
}

enum class PlayState {
    Playing, Paused, Stopped, Loading
}

interface KMPPlayer {
    fun play(playlist: List<Playable>)
    fun getState(): PlayState

    fun getCurrentlyPlaying(): Playable

    fun getCurrentPlaylist(): List<Playable>

    fun playNext()
}


class KMPPlayerImpl : KMPPlayer {
    private val playlist = mutableListOf<Playable>()
    private var currentIndex = 0
    private var playState = PlayState.Stopped
    override fun play(playlist: List<Playable>) {
        this.playlist.clear()
        this.playlist.addAll(playlist)
        playState = PlayState.Playing
    }

    override fun getState(): PlayState {
        return playState
    }

    override fun getCurrentlyPlaying(): Playable {
        return playlist[currentIndex]
    }

    override fun getCurrentPlaylist(): List<Playable> {
        return playlist
    }

    override fun playNext() {
        currentIndex = if (currentIndex < playlist.size - 1) currentIndex + 1 else currentIndex
    }
}