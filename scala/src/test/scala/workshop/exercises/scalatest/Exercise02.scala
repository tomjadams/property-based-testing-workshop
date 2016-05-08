package workshop.exercises.scalatest

import org.scalatest.{FunSpec, Matchers}

// =======
// Exercise: Test drive a function that subtracts two integers from each other.
// =======
final class Exercise02 extends FunSpec with Matchers {

  /*
   * Here is a simple function definition for subtracting two integers.
   */
  object Subtraction {
    def subtract(a: Integer, b: Integer): Integer = ???
  }

  describe("Subtracting two integers") {
    // Add your specs here...
  }

  /*
   * Great! Now go onto `scalacheck.Exercise03`.
   */
}
