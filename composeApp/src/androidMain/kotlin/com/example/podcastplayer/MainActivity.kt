package com.example.podcastplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.podcastplayer.di.initKoin
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        initKoin {
            modules(nativeModule)
            androidContext(this@MainActivity)
        }

        setContent {
            val player = get<AndroidPlayer>()
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}