package workshop.exercises.scalacheck

import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, PropSpec}

// =======
// Exercise: Write properties to test a function that adds two integers together.
// =======
final class Exercise01 extends PropSpec with PropertyChecks with Matchers {

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
   *
   *
   * Here's our addition function from before, we're going to be driving out its implementation again using the tests
   * below.
   */
  object Addition {
    def add(a: Int, b: Int): Int = a + b
//    def add(a: Int, b: Int): Int = ???
  }

  /*
   * The first thing that we need to do is create some inputs for our addition function. We do this using the `forAll`
   * function. We use this to create the property, as well as to generate inputs that we can use in the test. For
   * example, we can create a property that says that adding 0 to a number always is just the original number.
   *
   * forAll((n: Int) => (n + 0) should equal(1))
   *
   * Let's see that in an actual test.
   */
  property("Adding 0 to a number always returns the original number (std library +)") {
    forAll((n: Int) => (n + 0) should equal(n))
  }

  /*
   * Note that we are using the ScalaTest bindings for our properties, what that means is that we can use the matchers
   * we used earlier in our properties.
   *
   * Let's look at testing our addition function.
   *
   * Rewrite the property we just saw, but this time using our own addition function from above. You will need to go
   * back & implement the function to make the test pass, by replacing the `???` with your implementation.
   */
  property("Adding 0 to a number always returns the original number") {
    forAll((n: Int) => Addition.add(n, 0) should equal(n))
  }

  /*
   * We can pass more than one
   *
   * Write symmetric property that uses the standard subtraction function `-` to check that adding two numbers & taking
   * them away again is 0.
   */
    property("Adding two numbers & taking one away again is the first number") {
      forAll((a: Int, b: Int) => (Addition.add(a, b) - b) should equal(a))
    }

  /*
   * Write a property that
   */

  /*
   * Great! Now go onto `scalatest.Exercise02`.
   */
}
