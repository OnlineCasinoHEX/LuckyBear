package com.lucky.bear.states

import com.lucky.bear.controllers.ChowGirlController
import com.lucky.bear.graphics.ChowGirl

class ChowGirlCatchingState(private val chowGirl: ChowGirl, private val chowGirlController: ChowGirlController) : ChowGirlState {
    private val CHOW_CATCH_ANIMATE_LENGTH = 500
    private var timeToAnimate: Long = 0

    override fun init() {
        chowGirl.setGirlCatching()
        timeToAnimate = System.currentTimeMillis() + CHOW_CATCH_ANIMATE_LENGTH
    }

    override fun doAction() {
        if (System.currentTimeMillis() > timeToAnimate) {
            chowGirlController.stand()
        }
    }
}