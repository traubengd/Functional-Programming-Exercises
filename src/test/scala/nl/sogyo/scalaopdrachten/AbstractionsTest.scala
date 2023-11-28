package nl.sogyo.scalaopdrachten

import Abstractions.*

class AbstractionsTest extends munit.FunSuite:

    def double(x: Int): Int = x + x
    def isEven(x: Int): Boolean = x % 2 == 0

    test("map") {
        assertEquals(map(List(), double), List())
        assertEquals(map(List(1, 2, 3), double), List(2, 4, 6))
        assertEquals(
          map(List("aap", "noot", "mies"), s => s.length()),
          List(3, 4, 4)
        )
    }

    test("filter") {
        assertEquals(filter(List(), isEven), List())
        assertEquals(filter(List(1, 2, 3), isEven), List(2))
        assertEquals(
          filter(List("aap", "noot", "mies"), s => s.length() == 4),
          List("noot", "mies")
        )
    }

    test("forEach does nothing for empty list") {
        var counter = 0
        forEach(List(), (x: Int) => counter += x)
        assertEquals(counter, 0)
    }

    test("forEach performs an action for each element in the list") {
        var counter = 0
        forEach(List(1, 2, 3), x => counter += x)
        assertEquals(counter, 6)
    }

    test("forEach performs the actions from left to right") {
        var message = ""
        forEach(
          List("Watch", "Out", "For", "Side", "Effects"),
          s => message += s
        )
        assertEquals(message, "WatchOutForSideEffects")
    }

    test("reduce") {
        intercept[IllegalArgumentException](
          reduce(List(), (x: Int, y: Int) => x + y)
        )
        assertEquals(reduce(List(1, 2, 3), (x, y) => x + y), 6)
        assertEquals(
          reduce(
            List("Watch", "Out", "For", "Side", "Effects"),
            (s1, s2) => s1 + s2
          ),
          "WatchOutForSideEffects"
        )
    }

    test("zipWith") {
        assertEquals(
          zipWith(List(1, 2, 3), List(), (x, y: Int) => x + y),
          List()
        )
        assertEquals(
          zipWith(List(), List(4, 5, 6), (x: Int, y) => x + y),
          List()
        )
        assertEquals(
          zipWith(List(1, 2, 3), List(4, 5, 6), (x, y) => x + y),
          List(5, 7, 9)
        )
        assertEquals(
          zipWith(List(1, 2, 3), List(4, 5, 6, 7, 8, 9, 10), (x, y) => x + y),
          List(5, 7, 9)
        )
        assertEquals(
          zipWith(
            List("aap", "noot", "mies"),
            List(0, 1, 2),
            (string, index) => string.charAt(index)
          ),
          List('a', 'o', 'e')
        )
    }
