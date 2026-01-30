package com.example.podcastplayer.di

import com.example.podcastplayer.player.KMPPlayer
import com.example.podcastplayer.player.KMPPlayerImpl
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val sharedAppModule = module {
    singleOf(::KMPPlayerImpl) { bind<KMPPlayer>() }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedAppModule)
}
