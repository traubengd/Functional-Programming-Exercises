package nl.sogyo.scalaopdrachten

import nl.sogyo.scalaopdrachten.Streams.*

class StreamsTest extends munit.FunSuite:

    test("Processing strings") {
        val inputStream = LazyList("hello world", "to be or not to be", "Henk")
        val result = companyService(inputStream)
        assertEquals(result, "Hello, World, Not, Henk")
    }

    test("Streaming the natural numbers") {
        assertEquals(
          naturalNumbers.take(10).toList,
          List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        )
        assertEquals(naturalNumbers(10000), 10000)
    }

    test("Streaming the Fibonacci numbers") {
        assertEquals(
          fibonacciNumbers.take(10).toList,
          List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34).map(_.toLong)
        )
        assertEquals(fibonacciNumbers(50), 12586269025L)
    }
