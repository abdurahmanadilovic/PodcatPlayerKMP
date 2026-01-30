package com.example.podcastplayer

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val nativeModule = module {
    singleOf(::AndroidPlayer)
}

