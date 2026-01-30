package com.example.podcastplayer

import com.example.podcastplayer.player.NativePlayerEventsObserver
import com.example.podcastplayer.player.PlayState

class AndroidPlayer(val nativePlayerEventsObserver: NativePlayerEventsObserver) {
    init {
        nativePlayerEventsObserver.onPlayerStateChange(PlayState.Paused)
    }
}