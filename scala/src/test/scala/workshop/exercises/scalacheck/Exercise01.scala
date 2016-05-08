package workshop.exercises.scalacheck

import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, PropSpec}

// =======
// Exercise: Write properties to test a function that adds two integers together.
// =======
final class Exercise01 extends PropSpec with PropertyChecks with Matchers {

  /*
   * We're going to use ScalaCheck for our property testing, it's documentation is here if you need it:
   * https://www.scalacheck.org/documentation.html. If you get stuck, there are some good examples here:
   * https://github.com/oscarrenalias/scalacheck-examples/blob/master/scalacheck-integration-scalatest/src/test/scala/SimpleSpec.scala
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
   * Here's our addition function from before, we're going to be driving out its implementation again using the tests
   * below.
   */
  object Addition {
    def add(a: Int, b: Int): Int = a + b
//    def add(a: Int, b: Int): Int = ???
  }

  /*
   * The first thing that we need to do is create some inputs for our addition function. We do this using the `forAll`
   * function. This both creates the property, as well as generating inputs that we can use for the test. `forAll`
   * generates a bunch of random Ints, including edge cases, and run them through our test. This is far more efficient
   * than writing a bunch of examples manually and hoping to get them right, with enough coverage of the input space.
   *
   * Consider an integer for example, how many values do we need to use in order to test a broad spectrum of inputs?
   * We'd need to test some subset between -2147483648 and 2147483647. There's a lot of scope to get that wrong.
   * ScalaCheck will take care of generating appropriate inputs for us.
   *
   * Here is a property that says that the result of adding 0 to a number is always just the original number.
   *
   * forAll((n: Int) => (n + 0) should equal(1))
   *
   * What is happening is that ScalaCheck is generating us a bunch of random Int values and feeding them into our
   * function. It will generate edge cases, like min/max integers, zero, etc. as well as a broad scope of other values.
   *
   * Let's see that in a runnable test. Note that we are using the ScalaTest bindings for our properties, what that
   * means is that we can use the matchers we used earlier in our properties.
   */
  property("Adding 0 to a number always returns the original number (std library +)") {
    forAll((n: Int) => (n + 0) should equal(n))
  }

  /*
   * Let's look at testing our addition function.
   *
   * Rewrite the property we just saw, but this time using our own addition function from above. You will need to go
   * back & implement the function to make the test pass, by replacing the `???` with your implementation.
   */
  property("Adding 0 to a number always returns the original number") {
    forAll((n: Int) => Addition.add(n, 0) should equal(n))
  }

  /*
   * We can pass more than one argument to our function and ScalaCheck will generate us random values for all of these
   * parameters.
   *
   * Pass two Int arguments to our check & write symmetric property that uses the standard subtraction function `-` to
   * check that adding two numbers & taking one away again is the first number.
   */
    property("Adding two numbers & taking one away again is the first number") {
      forAll((a: Int, b: Int) => (Addition.add(a, b) - b) should equal(a))
    }

  /*
   * We can rewrite that in a couple of different ways.
   */
  property("2. Adding two numbers & taking one away again is the first number") {
    forAll((a: Int, b: Int) => (Addition.add(a, b) - a - b) should equal(0))
  }
  property("3. Adding two numbers & taking one away again is the first number") {
    forAll((a: Int, b: Int) => (Addition.add(a, b) - Addition.add(a, b)) should equal(0))
  }

  /*
   * Great! Now go onto `scalatest.Exercise02`.
   */
}
