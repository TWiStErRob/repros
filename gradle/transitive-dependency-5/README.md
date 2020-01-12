https://github.com/gradle/gradle/issues/11875

## Repro
```shell
gradlew jar
```

Note: Changing version in `gradle-wrapper.properties` to 4.10.3 makes it work. Any 5.x and 6.0.1 fails.

There are `gradlew dependencies` dumps in the `dependencies` folder.

## Expected
compiles

## Actual
```
> Task :compileJava FAILED
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:3: error: package org.ajoberstar.grgit does not exist
import org.ajoberstar.grgit.Grgit;
                           ^
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:4: error: package org.eclipse.jgit.revwalk does not exist
import org.eclipse.jgit.revwalk.RevWalk;
                               ^
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:9: error: cannot find symbol
        Grgit open() { return Grgit.open(new java.io.File(".")); }
        ^
  symbol:   class Grgit
  location: class GITPlugin
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:9: error: cannot find symbol
        Grgit open() { return Grgit.open(new java.io.File(".")); }
                              ^
  symbol:   variable Grgit
  location: class GITPlugin
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:12: error: cannot find symbol
                Grgit git = open();
                ^
  symbol:   class Grgit
  location: class GITPlugin
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:13: error: package org.eclipse.jgit.lib does not exist
                org.eclipse.jgit.lib.Repository repository = git.getRepository().getJgit().getRepository();
                                    ^
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:14: error: cannot find symbol
                RevWalk walk = new RevWalk(repository);
                ^
  symbol:   class RevWalk
  location: class GITPlugin
...\transitive-dependency-5\src\main\java\pack\GITPlugin.java:14: error: cannot find symbol
                RevWalk walk = new RevWalk(repository);
                                   ^
  symbol:   class RevWalk
  location: class GITPlugin
8 errors
```
