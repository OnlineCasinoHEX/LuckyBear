package com.lucky.bear.strategies

import com.lucky.bear.graphics.Sprite

interface SpriteUpdate {
    fun onUpdate(sprite: Sprite)
}