package com.example.podcastplayer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform