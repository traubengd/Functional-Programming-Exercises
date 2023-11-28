package nl.sogyo.scalaopdrachten

import nl.sogyo.scalaopdrachten.Functions.*

class FunctionsTest extends munit.FunSuite:

    def double(x: Int): Int = x + x
    def square(x: Int): Int = x * x
    def add(x: Int, y: Int) = x + y
    def multiply(x: Int, y: Int) = x * y
    def power(x: Int, y: Int): Int = math.pow(x, y).toInt
    def replicate[T](times: Int, element: T) = List.fill(times)(element)
    def concatenate(s1: String, s2: String) = s"${s1} ${s2}"

    test("compose") {
        assertEquals(compose(double, square)(3), 36)
        assertEquals(compose(square, double)(3), 18)
        assertEquals(compose(double, x => x.toString())(42), "84")
    }

    test("curry") {
        assertEquals(curry(add)(3)(4), 7)
        assertEquals(curry(multiply)(3)(4), 12)
        assertEquals(
          curry(replicate)(3)("hello"),
          List("hello", "hello", "hello")
        )
    }

    test("flip") {
        assertEquals(flip(power)(2, 10), 100)
        assertEquals(
          flip(replicate)("hello", 3),
          List("hello", "hello", "hello")
        )
        assertEquals(flip(concatenate)("hello", "world"), "world hello")
    }
