package com.example.napoleonit.petproject.root

import android.animation.*
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Handler
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.example.napoleonit.petproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


fun FloatingActionButton.setImagesFloatingAnimation(
    drawableProviders: List<() -> Drawable?>,
    @ColorInt firstColor: Int,
    @ColorInt secondColor: Int
) {

    var iterator = drawableProviders.iterator()

    var currentDrawable: Drawable? = null

    val imagesAnimator = ValueAnimator.ofFloat(1.0f, 0.0f)
        .apply {

            repeatMode = ValueAnimator.REVERSE
            repeatCount = 1
            duration = 500

            addUpdateListener { animator ->
                println("Images animator value: ${animator.animatedValue}")
                currentDrawable?.alpha = (((animator.animatedValue as? Float) ?: 1.0f) * 255).toInt()
            }

            addListener(object : AnimatorListenerAdapter() {

                var reverseFlag = false

                override fun onAnimationRepeat(animation: Animator) {
                    super.onAnimationRepeat(animation)

                    if (!iterator.hasNext())
                        iterator = drawableProviders.iterator()

                    reverseFlag = !reverseFlag

                    if (reverseFlag) {
                        currentDrawable = iterator.next().invoke()
                            .apply {
                                this?.alpha = 0
                            }
                        setImageDrawable(currentDrawable)
                    }
                }
            })
        }

    val colorAnimator = ValueAnimator.ofObject(
        ArgbEvaluator(),
        ContextCompat.getColor(context, R.color.black),
        ContextCompat.getColor(context, R.color.colorAccent)
    )
        .apply {
            duration = 1000

            addUpdateListener { animator ->
                backgroundTintList = ColorStateList.valueOf(animator.animatedValue as Int)
            }
        }


    val colorAnimatorReverse = ValueAnimator.ofObject(
        ArgbEvaluator(),
        ContextCompat.getColor(context, R.color.colorAccent),
        ContextCompat.getColor(context, R.color.black)
    )
        .apply {
            duration = 1000

            addUpdateListener { animator ->
                backgroundTintList = ColorStateList.valueOf(animator.animatedValue as Int)
            }
        }

    var colorReverse = false

    Handler().postDelayed(
        object : Runnable {
            override fun run() {

                val animationSet = AnimatorSet()

                if (colorReverse) {
                    animationSet.playTogether(imagesAnimator, colorAnimatorReverse)
                } else {
                    animationSet.playTogether(imagesAnimator, colorAnimator)
                }

                animationSet.start()

                colorReverse = !colorReverse
                postDelayed(this, 5000)
            }
        }, 1000
    )
}

