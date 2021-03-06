package com.lucky.bear.strategies

import android.graphics.Point
import com.lucky.bear.graphics.Sprite

private const val RANGE = 15

class SpriteUpdateLeftRight(screenDims: Point) : SpriteUpdate {
    private var moveX = -(screenDims.x.toFloat() * 0.0002083f)
    private var baseX = 0.0f

    override fun onUpdate(sprite: Sprite) {
        val currentX = sprite.x
        if (baseX == 0.0f) {
            baseX = currentX
        }

        if (currentX > baseX + RANGE || currentX < baseX - RANGE) {
            moveX = -moveX
        }

        sprite.moveX(moveX)
    }
}