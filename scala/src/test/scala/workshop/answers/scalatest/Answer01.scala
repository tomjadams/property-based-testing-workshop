package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}

final class Answer01 extends FunSpec with Matchers {

  object Addition {
    def add(a: Integer, b: Integer): Integer = a + b
  }

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
