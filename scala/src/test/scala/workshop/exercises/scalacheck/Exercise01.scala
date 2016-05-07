package workshop.exercises.scalacheck

import org.scalatest.{FunSpec, Matchers}

// =======
// Exercise: Write properties that to test a function that adds two integers together.
// =======
final class Exercise01 extends FunSpec with Matchers {

  /*
   * We're going to use ScalaCheck for our property testing, it's documentation is here if you need it:
   * https://www.scalacheck.org/documentation.html
   *
   */


  /*
   *
   */
  object Addition {
    def add(a: Integer, b: Integer): Integer = ???
  }

  /*
   *
   */
  describe("Adding two integers") {
    // Add your specs here...
  }
}
