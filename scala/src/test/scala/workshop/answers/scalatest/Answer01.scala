package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}
import workshop.Arithmetic

final class Answer01 extends FunSpec with Matchers {
  /*
   * Like most testing frameworks, ScalaTest allows a reasonable degree of customisation of its testing style.
   * In these exercises, we'll be using a style similar to rspec. More information on the kinds of specs:
   *   http://www.scalatest.org/user_guide/selecting_a_style
   *
   * ScalaTest has the notion of "matchers", where possible, you should use the typesafe variants:
   *   http://www.scalatest.org/user_guide/using_matchers
   */
  describe("I am a spec") {
    describe("that can be nested") {
      it("contains test code") {
        1 should equal(1) // not-typesafe
        1 should ===(1) // typesafe
      }
    }
  }

  describe("Adding two integers") {
    describe("Adding 0 to a number") {
      it("returns the same number") {
        Arithmetic.add(Integer.MIN_VALUE, 0) should equal(Integer.MIN_VALUE)
        Arithmetic.add(-99, 0) should equal(-99)
        Arithmetic.add(-2, 0) should equal(-2)
        Arithmetic.add(-1, 0) should equal(-1)
        Arithmetic.add(1, 0) should equal(1)
        Arithmetic.add(2, 0) should equal(2)
        Arithmetic.add(99, 0) should equal(99)
        Arithmetic.add(Integer.MAX_VALUE, 0) should equal(Integer.MAX_VALUE)
      }
    }

    describe("Adding a number to zero") {
      it("returns the number") {
        Arithmetic.add(0, Integer.MIN_VALUE) should equal(Integer.MIN_VALUE)
        Arithmetic.add(0, -99) should equal(-99)
        Arithmetic.add(0, -2) should equal(-2)
        Arithmetic.add(0, -1) should equal(-1)
        Arithmetic.add(0, 1) should equal(1)
        Arithmetic.add(0, 2) should equal(2)
        Arithmetic.add(0, 99) should equal(99)
        Arithmetic.add(0, Integer.MAX_VALUE) should equal(Integer.MAX_VALUE)
      }
    }

    describe("Adding two numbers") {
      it("returns the sum of them") {
        Arithmetic.add(Integer.MIN_VALUE, Integer.MIN_VALUE) should equal(0)
        Arithmetic.add(-50, -50) should equal(-100)
        Arithmetic.add(-1, -1) should equal(-2)
        Arithmetic.add(0, 0) should equal(0)
        Arithmetic.add(1, 1) should equal(2)
        Arithmetic.add(50, 50) should equal(100)
        Arithmetic.add(Integer.MAX_VALUE, Integer.MAX_VALUE) should equal(-2)
      }
    }
  }
}
