package com.lucky.bear.states

import android.graphics.Canvas

interface GameState {
    fun init()
    fun onUpdate(touchDown: Boolean, touchX: Float)
    fun onDraw(frameBufferCanvas: Canvas)
}