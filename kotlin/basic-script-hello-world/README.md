How to run:
```batch
set KT=p:\tools\lang\kotlin-1.7.10\lib
kotlinc -cp "%KT%\kotlin-main-kts.jar" Main.kt
kotlin -cp ".;%KT%\kotlin-main-kts.jar;%KT%\kotlin-scripting-compiler.jar;%KT%\kotlin-compiler.jar;%KT%\kotlin-scripting-compiler-impl.jar" MainKt
```
