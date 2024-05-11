package com.example

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal fun Modifier.repeatingClickable(
	interactionSource: InteractionSource,
	enabled: Boolean,
	maxDelayMillis: Long = 1000,
	minDelayMillis: Long = 5,
	delayDecayFactor: Float = .20f,
	onClick: () -> Unit,
): Modifier =
	composed {
		val currentClickListener by rememberUpdatedState(onClick)
		val isEnabled by rememberUpdatedState(enabled)

		pointerInput(interactionSource, isEnabled) {
			coroutineScope {
				awaitEachGesture {
					val down = awaitFirstDown(requireUnconsumed = false)
					val job = launch {
						var currentDelayMillis = maxDelayMillis
						while (isEnabled && down.pressed) {
							currentClickListener()
							delay(currentDelayMillis)
							val nextMillis =
								currentDelayMillis - currentDelayMillis * delayDecayFactor
							currentDelayMillis = nextMillis.toLong().coerceAtLeast(minDelayMillis)
						}
					}
					waitForUpOrCancellation()
					job.cancel()
				}
			}
		}
	}
