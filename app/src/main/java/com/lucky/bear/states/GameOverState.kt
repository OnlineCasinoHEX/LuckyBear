package com.lucky.bear.states

import android.graphics.Canvas
import com.lucky.bear.controllers.ChowController
import com.lucky.bear.controllers.ChowGirlController
import com.lucky.bear.controllers.ScoreController
import com.lucky.bear.graphics.Clouds
import com.lucky.bear.graphics.FallingSprites
import com.lucky.bear.graphics.Moon
import com.lucky.bear.strategies.SpriteUpdateDescendLeft
import com.lucky.bear.utils.ScreenUtils
import org.koin.core.KoinComponent
import org.koin.core.inject

private const val CHOW_END_WAIT: Long = 2000

class GameOverState(private val chowController: ChowController,
                    private val moon: Moon,
                    private val clouds: Clouds,
                    private val chowGirlController: ChowGirlController,
                    private val fallingSprites: FallingSprites,
                    private val scoreController: ScoreController) : GameState, KoinComponent {
    private val screenUtils: ScreenUtils by inject()
    private var endTime: Long = 0
    private var leftGame = false

    override fun init() {
        moon.setUpdateStrategy(SpriteUpdateDescendLeft(screenUtils.screenDims))
        endTime = System.currentTimeMillis() + CHOW_END_WAIT
        leftGame = false
    }

    override fun onUpdate(touchDown: Boolean, touchX: Float) {
        clouds.onUpdate()
        if (System.currentTimeMillis() > endTime && !leftGame) {
            leftGame = true
            chowController.leaveGame(scoreController.curScore)
        }
        moon.onUpdate()
        fallingSprites.onUpdate()
    }

    override fun onDraw(frameBufferCanvas: Canvas) {
        moon.onDraw(frameBufferCanvas)
        clouds.onDraw(frameBufferCanvas)
        scoreController.onDraw(frameBufferCanvas)
        fallingSprites.onDraw(frameBufferCanvas)
        chowGirlController.onDraw(frameBufferCanvas)
    }
}