package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}

// =======
// Exercise: Test drive a function that adds two integers together.
// =======
final class Answer01 extends FunSpec with Matchers {

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
    def add(a: Integer, b: Integer): Integer = a + b
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

  /*
   * Add your specs here...
   */
  describe("Adding two integers") {
    describe("Adding 0 to a number") {
      it("returns the same number") {
        Addition.add(Integer.MIN_VALUE, 0) should equal(Integer.MIN_VALUE)
        Addition.add(-99, 0) should equal(-99)
        Addition.add(-2, 0) should equal(-2)
        Addition.add(-1, 0) should equal(-1)
        Addition.add(1, 0) should equal(1)
        Addition.add(2, 0) should equal(2)
        Addition.add(99, 0) should equal(99)
        Addition.add(Integer.MAX_VALUE, 0) should equal(Integer.MAX_VALUE)
      }
    }

    describe("Adding a number to zero") {
      it("returns the number") {
        Addition.add(0, Integer.MIN_VALUE) should equal(Integer.MIN_VALUE)
        Addition.add(0, -99) should equal(-99)
        Addition.add(0, -2) should equal(-2)
        Addition.add(0, -1) should equal(-1)
        Addition.add(0, 1) should equal(1)
        Addition.add(0, 2) should equal(2)
        Addition.add(0, 99) should equal(99)
        Addition.add(0, Integer.MAX_VALUE) should equal(Integer.MAX_VALUE)
      }
    }

    describe("Adding two numbers") {
      it("returns the sum of them") {
        Addition.add(Integer.MIN_VALUE, Integer.MIN_VALUE) should equal(0)
        Addition.add(-50, -50) should equal(-100)
        Addition.add(-1, -1) should equal(-2)
        Addition.add(0, 0) should equal(0)
        Addition.add(1, 1) should equal(2)
        Addition.add(50, 50) should equal(100)
        Addition.add(Integer.MAX_VALUE, Integer.MAX_VALUE) should equal(-2)
      }
    }
  }
}
