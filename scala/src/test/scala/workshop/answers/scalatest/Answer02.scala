package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}
import workshop.Arithmetic

final class Answer02 extends FunSpec with Matchers {
  describe("Subtracting two integers") {
    describe("subtracting 0 from a number") {
      it("returns the same number") {
        Arithmetic.subtract(Integer.MIN_VALUE, 0) should equal(Integer.MIN_VALUE)
        Arithmetic.subtract(-99, 0) should equal(-99)
        Arithmetic.subtract(-2, 0) should equal(-2)
        Arithmetic.subtract(-1, 0) should equal(-1)
        Arithmetic.subtract(1, 0) should equal(1)
        Arithmetic.subtract(2, 0) should equal(2)
        Arithmetic.subtract(99, 0) should equal(99)
        Arithmetic.subtract(Integer.MAX_VALUE, 0) should equal(Integer.MAX_VALUE)
      }
    }

    describe("subtracting a number from zero") {
      it("returns the negative of that number") {
        Arithmetic.subtract(0, Integer.MIN_VALUE) should equal(Integer.MIN_VALUE)
        Arithmetic.subtract(0, -99) should equal(99)
        Arithmetic.subtract(0, -2) should equal(2)
        Arithmetic.subtract(0, -1) should equal(1)
        Arithmetic.subtract(0, 1) should equal(-1)
        Arithmetic.subtract(0, 2) should equal(-2)
        Arithmetic.subtract(0, 99) should equal(-99)
        Arithmetic.subtract(0, Integer.MAX_VALUE) should equal(-Integer.MAX_VALUE)
      }
    }

    describe("subtracting two numbers") {
      it("returns the subtraction of them") {
        Arithmetic.subtract(Integer.MIN_VALUE, Integer.MIN_VALUE) should equal(0)
        Arithmetic.subtract(-50, -50) should equal(0)
        Arithmetic.subtract(-1, -1) should equal(0)
        Arithmetic.subtract(0, 0) should equal(0)
        Arithmetic.subtract(1, 1) should equal(0)
        Arithmetic.subtract(50, 50) should equal(0)
        Arithmetic.subtract(Integer.MAX_VALUE, Integer.MAX_VALUE) should equal(0)
      }
    }
  }

  describe("Subtracting two integers") {
    describe("when empty") {
      it("should have size 0") {
        assert(Set.empty.size == 0)
      }
    }
  }
}
