package com.example

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.withFragment

internal val Fragment.mState: Int
	get() =
		Fragment::class.java
			.getDeclaredField("mState")
			.apply { isAccessible = true }
			.get(this) as Int

internal val Fragment.state: String
	get() =
		when (this.mState) { // based on constants in Fragment class
			-1 -> "INITIALIZING: Not yet attached."
			0 -> "ATTACHED: Attached to the host."
			1 -> "CREATED: Created."
			2 -> "VIEW_CREATED: View Created."
			3 -> "AWAITING_EXIT_EFFECTS: Downward state, awaiting exit effects"
			4 -> "ACTIVITY_CREATED: Fully created, not started."
			5 -> "STARTED: Created and started, not resumed."
			6 -> "AWAITING_ENTER_EFFECTS: Upward state, awaiting enter effects"
			7 -> "RESUMED: Created started and resumed."
			else -> "Unknown: different than what was available at version 1.3.0-beta01"
		}

internal val <reified F : Fragment> FragmentScenario<F>.state: String
	inline get() =
		try {
			this.withFragment { this.state }
		} catch (t: Throwable) {
			t.toString()
		}
