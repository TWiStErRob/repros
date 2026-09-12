package com.example

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface MyInterface
typealias TypeAlias = MyInterface
typealias AnotherTypeAlias = TypeAlias

class Repro {
	@Inject
	lateinit var member: AnotherTypeAlias
}

@Component(modules = [MyModule::class])
interface MyComponent {
	fun inject(repro: Repro)
}

@Module
class MyModule {
	@Provides
	fun provideMyInterface(): AnotherTypeAlias = object : MyInterface {}
}
