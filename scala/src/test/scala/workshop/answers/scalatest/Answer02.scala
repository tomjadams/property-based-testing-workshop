package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}

// =======
// Exercise: Test drive a function that subtracts two integers from each other.
// =======
final class Answer02 extends FunSpec with Matchers {

  /*
   * Here is a simple function definition for subtracting two integers.
   */
  object Subtraction {
    def subtract(a: Integer, b: Integer): Integer = a - b
  }

  /*
   * Add your specs here...
   */
  describe("Subtracting two integers") {
    describe("subtracting 0 from a number") {
      it("returns the same number") {
        Subtraction.subtract(Integer.MIN_VALUE, 0) should equal(Integer.MIN_VALUE)
        Subtraction.subtract(-99, 0) should equal(-99)
        Subtraction.subtract(-2, 0) should equal(-2)
        Subtraction.subtract(-1, 0) should equal(-1)
        Subtraction.subtract(1, 0) should equal(1)
        Subtraction.subtract(2, 0) should equal(2)
        Subtraction.subtract(99, 0) should equal(99)
        Subtraction.subtract(Integer.MAX_VALUE, 0) should equal(Integer.MAX_VALUE)
      }
    }

    describe("subtracting a number from zero") {
      it("returns the negative of that number") {
        Subtraction.subtract(0, Integer.MIN_VALUE) should equal(Integer.MIN_VALUE)
        Subtraction.subtract(0, -99) should equal(99)
        Subtraction.subtract(0, -2) should equal(2)
        Subtraction.subtract(0, -1) should equal(1)
        Subtraction.subtract(0, 1) should equal(-1)
        Subtraction.subtract(0, 2) should equal(-2)
        Subtraction.subtract(0, 99) should equal(-99)
        Subtraction.subtract(0, Integer.MAX_VALUE) should equal(-Integer.MAX_VALUE)
      }
    }

    describe("subtracting two numbers") {
      it("returns the subtraction of them") {
        Subtraction.subtract(Integer.MIN_VALUE, Integer.MIN_VALUE) should equal(0)
        Subtraction.subtract(-50, -50) should equal(0)
        Subtraction.subtract(-1, -1) should equal(0)
        Subtraction.subtract(0, 0) should equal(0)
        Subtraction.subtract(1, 1) should equal(0)
        Subtraction.subtract(50, 50) should equal(0)
        Subtraction.subtract(Integer.MAX_VALUE, Integer.MAX_VALUE) should equal(0)
      }
    }
  }
}
