echo Cleaning configuration cache...
rm -rf .gradle

echo Warmup Gradle
./gradlew

@echo '$ ./gradlew detekt'
./gradlew detekt

@echo '$ ./gradlew detekt -Pcom.example.enableTypeSolving=true'
./gradlew detekt -Pcom.example.enableTypeSolving=true

@echo '$ ./gradlew detekt -Pcom.example.enableTypeSolving=true'
./gradlew detekt -Pcom.example.enableTypeSolving=true

@echo '$ ./gradlew detekt -Pcom.example.enableTypeSolving=false'
./gradlew detekt -Pcom.example.enableTypeSolving=false

@echo '$ ./gradlew detekt -Pcom.example.enableTypeSolving=false'
./gradlew detekt -Pcom.example.enableTypeSolving=false

@echo '$ ./gradlew detekt -Pcom.example.enableTypeSolving=true'
./gradlew detekt -Pcom.example.enableTypeSolving=true
