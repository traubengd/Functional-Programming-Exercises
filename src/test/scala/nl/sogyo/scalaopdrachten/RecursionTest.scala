package nl.sogyo.scalaopdrachten

import Recursion.*

class RecursionTest extends munit.FunSuite:

    test("length with normal recursion") {
        assertEquals(length(List()), 0)
        assertEquals(length(List(42)), 1)
        assertEquals(length(List("Henk", "Piet", "Klaas")), 3)
    }

    test("length with tail recursion") {
        assertEquals(lengthTailRec(List()), 0)
        assertEquals(lengthTailRec(List(42)), 1)
        assertEquals(lengthTailRec(List("Henk", "Piet", "Klaas")), 3)
    }

    test("sumFirstNumbers with normal recursion") {
        intercept[IllegalArgumentException](sumFirstNumbers(-1))
        assertEquals(sumFirstNumbers(0), 0)
        assertEquals(sumFirstNumbers(1), 1)
        assertEquals(sumFirstNumbers(5), 15)
    }

    test("sumFirstNumbers with tail recursion") {
        intercept[IllegalArgumentException](sumFirstNumbersTailRec(-1))
        assertEquals(sumFirstNumbersTailRec(0), 0)
        assertEquals(sumFirstNumbersTailRec(1), 1)
        assertEquals(sumFirstNumbersTailRec(5), 15)
    }

    test("factorial") {
        intercept[IllegalArgumentException](factorial(-1))
        assertEquals(factorial(0), 1L)
        assertEquals(factorial(1), 1L)
        assertEquals(factorial(5), 120L)
    }

    test("replicate") {
        intercept[IllegalArgumentException](replicate(-1, -1))
        assertEquals(replicate(0, true), List())
        assertEquals(replicate(1, 42), List(42))
        assertEquals(
          replicate(5, "Henk"),
          List("Henk", "Henk", "Henk", "Henk", "Henk")
        )
    }

    test("sumArray") {
        assertEquals(sumArray(List()), 0)
        assertEquals(sumArray(List(42)), 42)
        assertEquals(sumArray(List(1, 2, 3)), 6)
    }

    test("isElementOf") {
        assert(!isElementOf("Henk", List()))
        assert(isElementOf(42, List(42)))
        assert(!isElementOf(43, List(42)))
        assert(!isElementOf(7, List(1, 2, 3, 4, 5, 6, 8, 9)))
        assert(isElementOf("mies", List("aap", "noot", "mies")))
    }

    test("range") {
        assertEquals(range(-1), List())
        assertEquals(range(0), List())
        assertEquals(range(1), List(0))
        assertEquals(range(5), List(0, 1, 2, 3, 4))
    }

    test("concatenate") {
        assertEquals(concatenate(List(), List()), List())
        assertEquals(
          concatenate(List(), List("aap", "noot", "mies")),
          List("aap", "noot", "mies")
        )
        assertEquals(
          concatenate(List("aap", "noot", "mies"), List()),
          List("aap", "noot", "mies")
        )
        assertEquals(
          concatenate(List(1, 2), List(3, 4, 5)),
          List(1, 2, 3, 4, 5)
        )
    }

    test("reverse") {
        assertEquals(reverse(List()), List())
        assertEquals(reverse(List(42)), List(42))
        assertEquals(
          reverse(List("aap", "noot", "mies")),
          List("mies", "noot", "aap")
        )
    }

    test("getElement") {
        val testList = List("aap", "noot", "mies")
        intercept[IndexOutOfBoundsException](getElement(testList, -1))
        assertEquals(getElement(testList, 0), "aap")
        assertEquals(getElement(testList, 1), "noot")
        assertEquals(getElement(testList, 2), "mies")
        intercept[IndexOutOfBoundsException](getElement(testList, 3))
    }
