package com.example

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentLifecycleTest {

	private inline fun <reified F : Fragment> FragmentScenario<F>.moveToStateLog(newState: Lifecycle.State) {
		Log.wtf("FragmentLifecycleTest", "FragmentScenario.moveToState($newState), currently ${this.state}")
		this.moveToState(newState)
		Log.wtf("FragmentLifecycleTest", "Finished moveToState($newState), moved to ${this.state}")
	}

	private fun separator() {
		Log.wtf("FragmentLifecycleTest", "------------------------------------------------")
	}

	@Test
	fun test() {
		separator()
		Log.wtf("FragmentLifecycleTest", "FragmentScenario.launch(initialState = DESTROYED)")
		val scenario = launchFragment<LifecycleListingFragment>(
			initialState = Lifecycle.State.DESTROYED
		)
		Log.wtf("FragmentLifecycleTest", "launchFragment returned $scenario, currently ${scenario.state}")
		separator()
		scenario.moveToStateLog(Lifecycle.State.INITIALIZED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.CREATED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.STARTED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.RESUMED)
		// running
		separator()
		scenario.moveToStateLog(Lifecycle.State.STARTED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.CREATED)
		// view destroyed
		separator()
		scenario.moveToStateLog(Lifecycle.State.STARTED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.RESUMED)
		// running again
		separator()
		scenario.moveToStateLog(Lifecycle.State.STARTED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.CREATED)
		separator()
		scenario.moveToStateLog(Lifecycle.State.DESTROYED)
		separator()
	}
}
