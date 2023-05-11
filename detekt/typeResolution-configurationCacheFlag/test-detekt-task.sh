echo Cleaning configuration cache...
rm -rf .gradle

echo Warmup Gradle
./gradlew

echo '$ ./gradlew detektFull'
./gradlew detektFull

echo '$ ./gradlew detektFull'
./gradlew detektFull

echo '$ ./gradlew detektLite'
./gradlew detektLite

echo '$ ./gradlew detektLite'
./gradlew detektLite

echo '$ ./gradlew detektFull'
./gradlew detektFull

