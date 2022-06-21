package com.lucky.bear.strategies

import android.graphics.Canvas
import com.lucky.bear.graphics.Sprite

class SpriteDrawStatic : SpriteDraw {
    override fun onDraw(canvas: Canvas, sprite: Sprite) {
        canvas.drawBitmap(sprite.getBitmap(), sprite.x, sprite.y, sprite.paint)
    }
}