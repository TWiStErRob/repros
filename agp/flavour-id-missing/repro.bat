cls
del out1.txt
del out2.txt
gradlew assemble -PagpVersion=8.0.0-alpha07 --quiet >out1.txt 2>&1
gradlew assemble -PagpVersion=8.0.0-alpha08 --quiet >out2.txt 2>&1
git diff
