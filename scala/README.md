# Scala Property-Based Testing Workshop

This is a Scala version of the property-based testing workshop.

It uses [`sbt`](http://www.scala-sbt.org/0.13/docs/index.html) as the build tool & is fully self contained.
[ScalaTest](http://www.scalatest.org) is used as the base testing framework, with [ScalaCheck](https://www.scalacheck.org)
used for property-based testing. You are welcome to use any editor you like.

# Workshop setup

1. Install [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) from Oracle. You will need a JDK, as of the time of writing this is "Java SE Development Kit 8u92".

1. Run `sbt`:

        $ ./bin/sbt
        > update

# Getting started

The workshop consists of both exercises, that you are asked to complete, along with answers, which can be referred to
if you are stuck. Following the usual Scala convention, tests live in `src/test/scala` and code lives in `src/main/scala`.

Within each of these directories, there is a folder for:

* `exercises` - these are the annotated exercises for you to complete;
* `answers` - these are sample answers to the exercises.

Within each of these, there are both regular style tests (using ScalaTest) in the `scalatest` folder, and property-based
tests (using ScalaCheck) in the `scalacheck` folder.

Start with the first exercise in the `scalatest` package, then do the corresponding `scalacheck` version, before moving
to the next exercise. It is recommended to tackle the exercises in this order:

* `scalatest.Exercise01` / `scalacheck.Exercise01` - test-drive a function that adds two integers;
* `scalatest.Exercise02` / `scalacheck.Exercise02` - test-drive a function that subtracts two integers;
* `scalatest.Exercise03` / `scalacheck.Exercise03` - test-drive functions to multiply & divide two integers;
* `scalatest.Exercise04` / `scalacheck.Exercise04` - test-drive the identity function;
* `scalatest.Exercise05` / `scalacheck.Exercise05` - test-drive a function that appends a string to another string;
* `scalatest.Exercise06` / `scalacheck.Exercise06` - test-drive a function that prepends a string to another string;
* `scalatest.Exercise07` / `scalacheck.Exercise07` - test-drive a function that reverses the elements in a list;
* `scalatest.Exercise08` / `scalacheck.Exercise08` - test-drive a function that finds the smallest element in a list;
* `scalatest.Exercise09` / `scalacheck.Exercise09` - test-drive a function that concatenates two lists to find
  their combined length;
* `scalatest.Exercise10` / `scalacheck.Exercise10` - test-drive functions that convert a string to a byte-array & back again;
* `scalatest.Exercise11` / `scalacheck.Exercise11` - test-drive a function that formats an address as a string;
* `scalatest.Exercise12` / `scalacheck.Exercise12` - test-drive a function that formats a price as a string;
* `scalatest.Exercise13` / `scalacheck.Exercise13` - test-drive a JSON codec;

Once you've started, read the instructions in the exercises, these will tell you where to go next.

The answers for each exercise are in the corresponding answers class, for example the answers to `Exercise01` live
in the class `Answer01`.

# Running the exercises

You can run & check your solutions using `sbt`:

```
$ ./bin/sbt
```

This will start the `sbt` REPL, from where you can issue [commands](http://www.scala-sbt.org/0.13/docs/Running.html#Common+commands).

* `test` - Runs all tests, use this to check your exercises;
* `test-only workshop.exercises.scalatest.Exercise01` - Runs a single test;
* `test-only workshop.exercises.*` - Runs all tests in the `workshop.exercises` package;
* `test:compile` - Compiles your test code.

Appending a `~` to the start of any command will run it continuously; for example to run tests continuously:

```
> ~test
```

# Uninstall

You can uninstall everything you installed for this workshop by:

```
$ rm -rf ~/.sbt
$ rm -rf ~/.ivy2
```

Then, if you want, you can uninstall Java by following the instructions here: https://docs.oracle.com/javase/8/docs/technotes/guides/install/mac_jdk.html#A1096903
