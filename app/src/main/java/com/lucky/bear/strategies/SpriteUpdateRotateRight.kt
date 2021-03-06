package com.lucky.bear.strategies

import android.graphics.Matrix
import com.lucky.bear.graphics.Sprite

class SpriteUpdateRotateRight : SpriteUpdate {
    private var rotationAngle: Int = 0

    override fun onUpdate(sprite: Sprite) {
        rotationAngle = (rotationAngle + 1) % 360
        val matrix = Matrix()

        matrix.postRotate(rotationAngle.toFloat(), (sprite.getWidth() / 2).toFloat(), (sprite.getHeight() / 2).toFloat())
        matrix.postTranslate(sprite.x, sprite.y)
        sprite.matrix = matrix
    }
}