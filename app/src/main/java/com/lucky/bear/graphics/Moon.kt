package com.lucky.bear.graphics

import android.graphics.Canvas
import com.lucky.bear.R
import com.lucky.bear.strategies.SpriteDrawStatic
import com.lucky.bear.strategies.SpriteUpdate
import com.lucky.bear.utils.ScreenUtils
import org.koin.core.KoinComponent
import org.koin.core.inject

const val MOON_FACE_HAPPY_1 = 0
const val MOON_FACE_HAPPY_2 = 1
const val MOON_FACE_SAD = 2

class Moon : KoinComponent {
    private val screenUtils: ScreenUtils by inject()
    private val moon = Sprite(R.drawable.moonface_happy1, TYPE_STATIC, null, SpriteDrawStatic())
    private val starBurst = Sprite(R.drawable.starburst_fade, TYPE_STATIC, null, SpriteDrawStatic())

    init {
        moon.addSprite(R.drawable.moonface_happy2)
        moon.addSprite(R.drawable.moonface_sad)
    }

    fun reset() {
        val screenWidth = screenUtils.screenDims.x
        moon.setXY(screenWidth - moon.getWidth() + screenUtils.pxToDp(80).toFloat(), screenUtils.pxToDp(128).toFloat())
        starBurst.setXY(screenUtils.centerSpriteX(starBurst, screenWidth), 0f)
        starBurst.paint.alpha = 255
        moon.updateStrategy = null
        moon.paint.alpha = 255
        starBurst.updateStrategy = null
        moon.paint.alpha = 255
        moon.currentSprite = 0
    }

    fun getCurrentSprite(): Int {
        return moon.currentSprite
    }

    fun setCurrentSprite(currentSprite: Int) {
        moon.currentSprite = currentSprite
    }

    fun setUpdateStrategy(updateStrategy: SpriteUpdate) {
        moon.updateStrategy = updateStrategy
        starBurst.updateStrategy = updateStrategy
    }

    fun onUpdate() {
        starBurst.onUpdate()
        moon.onUpdate()
    }

    fun onDraw(frameBufferCanvas: Canvas) {
        starBurst.onDraw(frameBufferCanvas)
        moon.onDraw(frameBufferCanvas)
    }
}