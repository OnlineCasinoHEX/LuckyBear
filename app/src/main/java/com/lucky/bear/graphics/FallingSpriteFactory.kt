package com.lucky.bear.graphics

import com.lucky.bear.R
import com.lucky.bear.strategies.SpriteDrawRotate
import com.lucky.bear.strategies.SpriteUpdate
import com.lucky.bear.strategies.SpriteUpdateRotateLeft
import com.lucky.bear.strategies.SpriteUpdateRotateRight

private const val ROTATE_RIGHT = 1
private const val ROTATE_LEFT = 2

class FallingSpriteFactory {
    fun getSprite(type: Int, rotationType: Int): Sprite? {
        var updateStrategy: SpriteUpdate? = null
        if (rotationType == ROTATE_LEFT) {
            updateStrategy = SpriteUpdateRotateLeft()
        } else if (rotationType == ROTATE_RIGHT) {
            updateStrategy = SpriteUpdateRotateRight()
        }
        val drawStrategy = SpriteDrawRotate()
        var sprite: Sprite? = null
        when (type) {
            0 -> {
                sprite = Sprite(R.drawable.bomb, TYPE_BOMB, updateStrategy, drawStrategy)
                sprite.addSprite(R.drawable.bomb_explode)
            }
            1 -> sprite = Sprite(R.drawable.broccoli, TYPE_VEGGIE, updateStrategy, drawStrategy)
            2 -> sprite = Sprite(R.drawable.bubble_tea_green, TYPE_BUBBLE_TEA, updateStrategy, drawStrategy)
            3 -> sprite = Sprite(R.drawable.bubble_tea_orange, TYPE_BUBBLE_TEA, updateStrategy, drawStrategy)
            4 -> sprite = Sprite(R.drawable.bubble_tea_pink, TYPE_BUBBLE_TEA, updateStrategy, drawStrategy)
            5 -> sprite = Sprite(R.drawable.bubble_tea_purple, TYPE_BUBBLE_TEA, updateStrategy, drawStrategy)
            6 -> sprite = Sprite(R.drawable.carrot, TYPE_VEGGIE, updateStrategy, drawStrategy)
            7 -> sprite = Sprite(R.drawable.garlic, TYPE_VEGGIE, updateStrategy, drawStrategy)
            8 -> sprite = Sprite(R.drawable.star_bonus, TYPE_STAR,updateStrategy, drawStrategy)
            9 -> sprite = Sprite(R.drawable.tomato, TYPE_VEGGIE, updateStrategy, drawStrategy)
        }
        return sprite
    }
}