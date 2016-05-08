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
   * When writing property-based tests, like in a lot of software development, it's often helpful to look for patterns,
   * these make writing tests easier. For example, you can write a function that turns a String into UTF-8 encoded byte
   * array, and then another from a byte array back into a String. This pattern is called symmetry, and you might call
   * the test for these functions "symmetrical tests".
   *
   * Assuming that we have our two functions as follows:
   *
   *   def toBytes(s: String, c: Charset): Array[Byte]
   *   def fromBytes(b: Array[Bytes], c: Charset): String
   *
   * We can write a symmetric test for these that looks something like:
   *
   *   val str = "abc"
   *   val charset = ...
   *   val bytes = toBytes(str, charset)
   *   fromBytes(bytes, charset) == str
   *
   * Sometimes, you may not have a pair of functions
    *
   * be able to come up with a symmetric
    *
   * you won't be able to come up with a symmetric test for a function
   *
   * For this, we may be able
   *
   * model-based, test-oracle
   *
   * We'll be exploiting these patterns when writing property-based tests, to make our life simple by making it easier
   * to come up with tests.
   */

  /*
   * Here's our addition function from before, we're going to be driving out its implementation again.
   */
  object Addition {
    def add(a: Int, b: Int): Int = ???
  }

  /*
   * The first thing that we need to do is create some random inputs for our addition function. We do this by importing
   * the `forAll` function like so:
   */

  import org.scalacheck.Prop.forAll

  /*
   *
   */
  describe("Adding two integers") {
    // Add your specs here...
  }


  /*
   * Great! Now go onto `scalatest.Exercise02`.
   */
}
