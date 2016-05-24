package workshop.exercises.scalacheck

import org.scalacheck.Prop
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
   * When writing property-based tests, like in a lot of software development, it's often helpful to look for patterns
   * that make writing tests easier. For example, you can write a function that turns a String into UTF-8 encoded byte
   * array, and then another from a byte array back into a String. This is called symmetry, and you might call a test
   * for these functions a "symmetrical test".
   *
   * So, assuming that we have our two functions as follows:
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
   * Sometimes, you may not have a nice pair of functions, that are the opposite of each other. But you may have an
   * equivalent or similar function that you can use to test the results. For example, for our `add` function, we have
   * the system `+` function that we can use to test our result. This is often called a "test-oracle".
   *
   * Another nice pattern you can exploit, is that of invariants. For example suppose that you're testing a tax
   * calculation function. Above a certain salary, all users will have the same tax rate. Here are some other examples:
   *
   * * Mapping the identity function across a list is equivalent to the list: `list.map(a => a) should equal(list)`;
   * * Looking for an element in a list with a predicate that always returns true returns a list of length 1:
   *   `list.filter(a => true).length should equal(1)`.
   *
   * The last pattern that we'll be using is idempotence. We can use this to test things like sorting a list twice is
   * the same as sorting it once, or finding the unique elements in a list twice is the same as uniquing it once. You
   * could also test that adding a user to the database twice is the same as adding it once, or migrating it to the same
   * version twice is the same as migrating to that version once.
   *
   * We'll be exploiting these patterns when writing property-based tests throughout this workshop, making it easier to
   * come up with tests.
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
   * There are other ways that we can define our addition function, for example we can use the fact that addition and
   * multiplication are related.
   */
  property("Addition is related to multiplication") {
    // Write a property that ensures that adding a number to itself is the same as doubling the number.
    forAll((n: Int) => Addition.add(n, n) should equal(2 * n))

    // Write a property that ensures that adding a number to itself three times is the same as tripling the number.
    forAll((n: Int) => Addition.add(Addition.add(n, n), n) should equal(3 * n))
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
  property("Adding two numbers & taking them both away is zero") {
    // Rewrite the property by adding the two numbers, and then using the std - function to take them both away
    forAll((a: Int, b: Int) => (Addition.add(a, b) - a - b) should equal(0))
  }
  property("Adding two numbers & taking their sum away is zero") {
    // Rewrite the property by adding the two numbers, then taking away their sum, using our add function
    forAll((a: Int, b: Int) => (Addition.add(a, b) - Addition.add(a, b)) should equal(0))
  }

  /*
   * Great! Now go onto `scalatest.Exercise02`.
   */
}
