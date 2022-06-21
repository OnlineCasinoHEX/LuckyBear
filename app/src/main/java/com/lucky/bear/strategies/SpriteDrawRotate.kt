package com.lucky.bear.strategies

import android.graphics.Canvas
import com.lucky.bear.graphics.Sprite

class SpriteDrawRotate : SpriteDraw {
    override fun onDraw(canvas: Canvas, sprite: Sprite) {
        val matrix = sprite.matrix
        if (matrix != null) {
            canvas.drawBitmap(sprite.getBitmap(), matrix, null)
        }
    }
}