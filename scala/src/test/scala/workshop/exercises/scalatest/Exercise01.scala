package workshop.exercises.scalatest

import org.scalatest.{FunSpec, Matchers}

// =======
// Exercise: Test drive a function that adds two integers together.
// =======
final class Exercise01 extends FunSpec with Matchers {

  /*
   * An `object` in Scala is a class without state. It's similar# to a mixin in Ruby or a class with only static
   * methods (and constants) in Java. For classes that contain just pure functions, or immutable constants, an object
   * is usually the best place to put those functions/variables.
   *
   * #A `trait` in Scala is closer to a Ruby mixin.
   */
  object Addition {
    /*
     * In Scala, a function looks like:
     *
     * def foo(argument: ArgumentType): ReturnType = {
     *   ... code goes here
     * }
     *
     * Like Ruby, you do not need an explicit `return`, the result of the last expression is returned.
     *
     * For simple functions (that contain only a single expression), you can ommit the parentheses:
     *
     * def concat(a: String, b: String): String = a + b
     *
     * Here is a simple function definition for adding two numbers. The `???` is a shorthand notation that
     * throws an exception when executed (while satisfying the compiler), it's used as a reminder that something
     * hasn't been implemented.
     *
     */
    def add(a: Int, b: Int): Int = ???
  }

  /*
  * Like most testing frameworks, ScalaTest allows a reasonable degree of customisation of its testing style.
  * In these exercises, we'll be using a style similar to rspec.
  *
  * ScalaTest has the notion of "matchers", where possible, you should use the typesafe variants. Here is the
  * documentation: http://www.scalatest.org/user_guide/using_matchers
  */
  describe("A spec") {
    describe("that is nested") {
      it("contains code that tests things") {
        1 should equal(1) // not-typesafe
        1 should ===(1) // typesafe
      }
    }
  }

  describe("Adding two integers") {
    // Add your specs here...
  }

  /*
   * Great! Now go onto `scalacheck.Exercise01`.
   */
}
