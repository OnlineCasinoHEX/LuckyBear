package com.lucky.bear.strategies

import android.graphics.Canvas
import com.lucky.bear.graphics.Sprite

interface SpriteDraw {
    fun onDraw(canvas: Canvas, sprite: Sprite)
}