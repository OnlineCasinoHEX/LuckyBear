package com.lucky.bear.activities

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lucky.bear.R
import com.lucky.bear.animations.PulseAnimation
import com.lucky.bear.controllers.CHOW_SONGS_KEY
import com.lucky.bear.controllers.ChowSongs
import com.lucky.bear.controllers.ChowSounds
import com.lucky.bear.di.setActivity
import com.lucky.bear.utils.PreferencesWrapper
import kotlinx.android.synthetic.main.activity_main_menu.*
import org.koin.android.ext.android.inject

class ActivityMainMenu : AppCompatActivity() {
    private val preferences: PreferencesWrapper by inject()
    private val chowSongs: ChowSongs by inject()
    private val chowSounds: ChowSounds by inject()
    private var soundOn: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        setActivity(this)

        button_sound.setOnClickListener {
            soundOn = !soundOn
            handleSoundButton(soundOn)
        }

        button_instructions.setOnClickListener {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)
            pulse.setAnimationListener(PulseAnimation(this, ActivityInstructions::class.java))
            button_instructions.startAnimation(pulse)
        }

        button_play.setOnClickListener {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)
            pulse.setAnimationListener(PulseAnimation(this, ActivityGame::class.java))
            button_play.startAnimation(pulse)
        }
    }

    override fun onResume() {
        super.onResume()
        soundOn = preferences.getBoolean(CHOW_SONGS_KEY, true)
        handleSoundButton(soundOn)
    }

    private fun handleSoundButton(isOn: Boolean) {
        chowSounds.isOn = isOn
        if (isOn) {
            button_sound.setImageResource(R.drawable.sound_on)
            preferences.putBoolean(CHOW_SONGS_KEY, true)
            chowSongs.play(this, R.raw.main_theme)
        } else {
            button_sound.setImageResource(R.drawable.sound_off)
            preferences.putBoolean(CHOW_SONGS_KEY, false)
            chowSongs.pause()
        }
    }
}