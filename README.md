# Property Based Testing Workshop

> "Writing tests first forces you to think about the problem you're solving. Writing property-based tests forces you to think way harder." [@jessitron](https://twitter.com/jessitron/status/327480330900611072)

This is a simple workshop for teaching property based testing.

The goal of this workshop is to give you an introduction to property-based testing, as well as show you how & why you
might use it instead of (or in conjuntion with) other testing techniques. We'll be doing this by showing common TDD
techniques such as triangulation and then using a property-based testing to achieve the same goals.

# Further reading

The [ScalaCheck documentation](https://www.scalacheck.org/documentation.html) page lists a number of good resources for
getting started with property based testing. In particular I found these useful:

* [How I learned to stop unit testing and love property-based testing](https://yow.eventer.com/yow-lambda-jam-2015-1305/practical-property-based-testing-by-charles-o-farrell-1884) - Charles O'Farrell, YOW! LambdaJam 2015 ([slides]( (http://blog.charleso.org/property-testing-preso/yowlj2015.html)));
* [ScalaCheck User's Guide](https://github.com/rickynils/scalacheck/blob/master/doc/UserGuide.md)

# Implementation languages

This workshop is available for several languages:

* [Scala](./scala/README.md);
* Swift - see [SwiftCheck](https://github.com/typelift/SwiftCheck) & [Fox](https://github.com/jeffh/Fox);
* Ruby -  see [Propr](https://github.com/kputnam/propr).
