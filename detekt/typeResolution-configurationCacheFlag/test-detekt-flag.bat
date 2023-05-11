@echo off

@echo Cleaning configuration cache...
rmdir /s /q .gradle

@echo Warmup Gradle
call gradlew

@echo $ gradlew detekt
call gradlew detekt

@echo $ gradlew detekt -Pcom.example.enableTypeSolving=true
call gradlew detekt -Pcom.example.enableTypeSolving=true

@echo $ gradlew detekt -Pcom.example.enableTypeSolving=true
call gradlew detekt -Pcom.example.enableTypeSolving=true

@echo $ gradlew detekt -Pcom.example.enableTypeSolving=false
call gradlew detekt -Pcom.example.enableTypeSolving=false

@echo $ gradlew detekt -Pcom.example.enableTypeSolving=false
call gradlew detekt -Pcom.example.enableTypeSolving=false

@echo $ gradlew detekt -Pcom.example.enableTypeSolving=true
call gradlew detekt -Pcom.example.enableTypeSolving=true
