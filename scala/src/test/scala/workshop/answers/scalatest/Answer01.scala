package workshop.answers.scalatest

import org.scalatest.{FunSpec, Matchers}

final class Answer01 extends FunSpec with Matchers {

  object Addition {
    def add(a: Int, b: Int): Int = a + b
  }

  describe("Adding two integers") {
    describe("Adding 0 to a number") {
      it("returns the same number") {
        Addition.add(Int.MinValue, 0) should equal(Int.MinValue)
        Addition.add(-99, 0) should equal(-99)
        Addition.add(-2, 0) should equal(-2)
        Addition.add(-1, 0) should equal(-1)
        Addition.add(1, 0) should equal(1)
        Addition.add(2, 0) should equal(2)
        Addition.add(99, 0) should equal(99)
        Addition.add(Int.MaxValue, 0) should equal(Int.MaxValue)
      }
    }

    describe("Adding a number to zero") {
      it("returns the number") {
        Addition.add(0, Int.MinValue) should equal(Int.MinValue)
        Addition.add(0, -99) should equal(-99)
        Addition.add(0, -2) should equal(-2)
        Addition.add(0, -1) should equal(-1)
        Addition.add(0, 1) should equal(1)
        Addition.add(0, 2) should equal(2)
        Addition.add(0, 99) should equal(99)
        Addition.add(0, Int.MaxValue) should equal(Int.MaxValue)
      }
    }

    describe("Adding two numbers") {
      it("returns the sum of them") {
        Addition.add(Int.MinValue, Int.MinValue) should equal(0)
        Addition.add(-50, -50) should equal(-100)
        Addition.add(-1, -1) should equal(-2)
        Addition.add(0, 0) should equal(0)
        Addition.add(1, 1) should equal(2)
        Addition.add(50, 50) should equal(100)
        Addition.add(Int.MaxValue, Int.MaxValue) should equal(-2)
      }
    }
  }
}
