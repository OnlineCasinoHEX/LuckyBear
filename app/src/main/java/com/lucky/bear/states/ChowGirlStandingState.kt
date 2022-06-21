package com.lucky.bear.states

import com.lucky.bear.graphics.ChowGirl

class ChowGirlStandingState(private val chowGirl: ChowGirl) : ChowGirlState {
    override fun init() {
        chowGirl.setGirlStanding()
    }

    override fun doAction() {
    }
}