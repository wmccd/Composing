package com.wmccd.composing.extensions

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.redball(): Modifier =
    clip(CircleShape)
    .background(Color.Red)

fun Modifier.rotatingSquare(durationInMillis: Int): Modifier = composed {

    val transition = rememberInfiniteTransition()
    val angleRatio by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationInMillis)
        )
    )
    graphicsLayer {
        rotationZ = 360f * angleRatio
    }
}
