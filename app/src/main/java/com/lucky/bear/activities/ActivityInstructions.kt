package com.lucky.bear.activities

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lucky.bear.R
import com.lucky.bear.R.layout.activity_instructions
import com.lucky.bear.animations.PulseAnimation
import kotlinx.android.synthetic.main.activity_instructions.*

class ActivityInstructions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_instructions)

        inst_button_play.setOnClickListener {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)
            pulse.setAnimationListener(PulseAnimation(this, ActivityGame::class.java))
            inst_button_play.startAnimation(pulse)
        }
    }
}