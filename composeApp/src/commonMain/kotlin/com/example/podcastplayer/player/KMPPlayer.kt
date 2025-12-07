package com.example.podcastplayer.player

data class Playable(val uri: String)

enum class PlayState {
    Playing, Paused, Stopped, Loading
}

interface KMPPlayer {
    fun play(playlist: List<Playable>)
    fun getState(): PlayState
}


class KMPPlayerImpl : KMPPlayer {
    private var playState = PlayState.Stopped
    override fun play(playlist: List<Playable>) {
        playState = PlayState.Playing
    }

    override fun getState(): PlayState {
        return playState
    }
}