package com.lucky.bear.graphics

import android.graphics.Bitmap
import android.graphics.Canvas
import com.lucky.bear.R
import org.koin.core.KoinComponent
import org.koin.core.inject

class Background : KoinComponent{
    private val spriteBitmapFactory: SpriteBitmapFactory by inject()
    private val background: Bitmap? = spriteBitmapFactory.getBitmap(R.drawable.game_background)

    fun onDraw(canvas: Canvas) {
        background?.let {
            canvas.drawBitmap(background, 0f, 0f, null)
        }
    }
}