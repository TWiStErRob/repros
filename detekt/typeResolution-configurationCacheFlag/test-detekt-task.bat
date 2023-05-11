@echo off

@echo Cleaning configuration cache...
rmdir /s /q .gradle

@echo Warmup Gradle
call gradlew

@echo $ gradlew detektFull
call gradlew detektFull

@echo $ gradlew detektFull
call gradlew detektFull

@echo $ gradlew detektLite
call gradlew detektLite

@echo $ gradlew detektLite
call gradlew detektLite

@echo $ gradlew detektFull
call gradlew detektFull
