# Scala Property-Based Testing Workshop

This is a Scala version of the property based testing workshop.

It uses [`sbt`](http://www.scala-sbt.org/0.13/docs/index.html) as the build tool & is fully self contained.
[ScalaTest](http://www.scalatest.org) is used as the base testing framework, with [ScalaCheck](https://www.scalacheck.org)
used as the property-based testing framework. You are welcome to use any editor you like.

# Setup

1. Install [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) from Oracle.

1. Run `sbt`:

        $ ./bin/sbt
        > update

# Getting started

The workshop consists of both exercises, that you are asked to complete, along with answers, which can be referred to
if you are stuck. Following the usual Scala convention, tests live in `src/test/scala` and code lives in `src/main/scala`.

Within each of these directories, there is a folder for:

* `exercises` - these are the annotated exercises for you to complete;
* `answers` - these are sample answers to the exercises.

Also, there are both regular style tests (using ScalaTest) in the `scalatest` folder, and property-based tests (using
ScalaCheck) in the `scalacheck` folder.

Start with the exercises in the following order:

* `src/test/scala/exercises/scalatest/Exercise01.scala`;
* `src/test/scala/exercises/calacheck/Exercise01.scala`.

Once you've started, read the instructions in the exercises, these will tell you where to go next.

# Running the exercises

You can run & check your solutions using `sbt`:

```
$ ./bin/sbt
```

This will start the `sbt` REPL, from where you can issue commands.

To check your exercises, run the `test` command:

```
> test
```

If you just wish to compile your test code, you can do so using:

```
> compile
```

# Uninstall

You can uninstall everything installed by this workshop by:

```
$ rm -rf ~/.sbt
$ rm -rf ~/.ivy2
```
