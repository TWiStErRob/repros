package com.example

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LifecycleListingFragment : Fragment() {
	private fun log(method: String, vararg args: Any?) {
		Log.wtf("LifecycleListingFragment", "$method(${args.joinToString()})")
	}

	init {
		log("ctor")
	}

	override fun setArguments(args: Bundle?) {
		log("setArguments", args)
		super.setArguments(args)
	}

	override fun onAttach(context: Context) {
		log("onAttach", context)
		super.onAttach(context)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		log("onCreate", savedInstanceState)
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		log("onCreateView", container)
		return super.onCreateView(inflater, container, savedInstanceState)
	}

	override fun onStart() {
		log("onStart")
		super.onStart()
	}

	override fun onResume() {
		log("onResume")
		super.onResume()
	}

	override fun onPause() {
		log("onPause")
		super.onPause()
	}

	override fun onStop() {
		log("onStop")
		super.onStop()
	}

	override fun onDestroyView() {
		log("onDestroyView")
		super.onDestroyView()
	}

	override fun onDestroy() {
		log("onDestroy")
		super.onDestroy()
	}

	override fun onDetach() {
		log("onDetach")
		super.onDetach()
	}
}
