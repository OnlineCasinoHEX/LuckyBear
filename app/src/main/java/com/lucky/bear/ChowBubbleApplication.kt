package com.lucky.bear

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.lucky.bear.controllers.CHOW_SONGS_KEY
import com.lucky.bear.controllers.ChowSongs
import com.lucky.bear.controllers.ChowSounds
import com.lucky.bear.di.appModule
import com.lucky.bear.utils.PreferencesWrapper
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChowBubbleApplication : Application(), LifecycleObserver {
    private val chowSongs: ChowSongs by inject()
    private val chowSounds: ChowSounds by inject()
    private val preferences: PreferencesWrapper by inject()
    private var isOn: Boolean? = false
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChowBubbleApplication)
            modules(appModule)
        }

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun OnAppStart() {
        isOn = preferences.getBoolean(CHOW_SONGS_KEY, false)
        if (isOn!!) {
            chowSongs.play(this, R.raw.main_theme)
        }
        chowSounds.init(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun OnAppResume() {
        if (isOn!!) {
            chowSongs.play(this, R.raw.main_theme)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun OnAppPause() {
        chowSongs.pause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun OnAppStop() {
        chowSongs.stop()
        chowSounds.release()
    }
}