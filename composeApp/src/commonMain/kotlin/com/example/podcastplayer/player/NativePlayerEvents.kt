package com.example.podcastplayer.player

interface NativePlayerEventsObserver {
    fun onPlayerStateChange(newPlayState: PlayState)
}
