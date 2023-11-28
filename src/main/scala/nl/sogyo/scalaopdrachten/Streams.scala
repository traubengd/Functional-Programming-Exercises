package nl.sogyo.scalaopdrachten

import nl.sogyo.scalaopdrachten.Recursion.length

object Streams:

    def companyService(phrases: LazyList[String]): String =
        phrases.flatMap(_.split(" "))
        .filter(_.length() >= 3)
        .map(_.capitalize)
        .mkString(", ")

    def integersFrom(start: Int): LazyList[Int] =
        start #:: integersFrom(start + 1)

    def naturalNumbers: LazyList[Int] = integersFrom(0)

    def fibonacciStartingWith(first: Long, second: Long): LazyList[Long] = 
        val nextNumber = first + second
        LazyList(first).lazyAppendedAll(fibonacciStartingWith(second, nextNumber))

    def fibonacciNumbers: LazyList[Long] = fibonacciStartingWith(0, 1)
