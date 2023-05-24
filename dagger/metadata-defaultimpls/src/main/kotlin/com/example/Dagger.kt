package com.example

import dagger.BindsInstance
import dagger.Component

@Component
interface MyComponent {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun instance(param: String = "default"): Builder

		fun build(): MyComponent
	}
}
