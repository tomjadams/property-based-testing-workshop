package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}

final class Answer02 extends FunSpec with Matchers {

  object Subtraction {
    def subtract(a: Int, b: Int): Int = a - b
  }

  describe("Subtracting two integers") {
    describe("subtracting 0 from a number") {
      it("returns the same number") {
        Subtraction.subtract(Int.MinValue, 0) should equal(Int.MinValue)
        Subtraction.subtract(-99, 0) should equal(-99)
        Subtraction.subtract(-2, 0) should equal(-2)
        Subtraction.subtract(-1, 0) should equal(-1)
        Subtraction.subtract(1, 0) should equal(1)
        Subtraction.subtract(2, 0) should equal(2)
        Subtraction.subtract(99, 0) should equal(99)
        Subtraction.subtract(Int.MaxValue, 0) should equal(Int.MaxValue)
      }
    }

    describe("subtracting a number from zero") {
      it("returns the negative of that number") {
        Subtraction.subtract(0, Int.MinValue) should equal(Int.MinValue)
        Subtraction.subtract(0, -99) should equal(99)
        Subtraction.subtract(0, -2) should equal(2)
        Subtraction.subtract(0, -1) should equal(1)
        Subtraction.subtract(0, 1) should equal(-1)
        Subtraction.subtract(0, 2) should equal(-2)
        Subtraction.subtract(0, 99) should equal(-99)
        Subtraction.subtract(0, Int.MaxValue) should equal(-Int.MaxValue)
      }
    }

    describe("subtracting two numbers") {
      it("returns the subtraction of them") {
        Subtraction.subtract(Int.MinValue, Int.MinValue) should equal(0)
        Subtraction.subtract(-50, -50) should equal(0)
        Subtraction.subtract(-1, -1) should equal(0)
        Subtraction.subtract(0, 0) should equal(0)
        Subtraction.subtract(1, 1) should equal(0)
        Subtraction.subtract(50, 50) should equal(0)
        Subtraction.subtract(Int.MaxValue, Int.MaxValue) should equal(0)
      }
    }
  }
}
