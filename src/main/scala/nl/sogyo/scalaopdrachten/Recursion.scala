package nl.sogyo.scalaopdrachten

import scala.annotation.tailrec

object Recursion:

    def length[T](array: List[T]): Int = array match
        case Nil          => 0
        case head :: next => 1 + length(next)

    def lengthTailRec[T](array: List[T]): Int = lengthHelper(array, 0)

    @tailrec
    private def lengthHelper[T](array: List[T], accumulator: Int): Int =
        array match
            case Nil          => accumulator
            case head :: next => lengthHelper(next, 1 + accumulator)

    def sumFirstNumbers(upUntil: Int): Int =
        if upUntil < 0 then
            throw new IllegalArgumentException("negative number")
        upUntil match
            case 0 => 0
            case n => n + sumFirstNumbers(n - 1)

    def sumFirstNumbersTailRec(upUntil: Int): Int =
        sumFirstNumbersHelper(upUntil, 0)

    @tailrec
    private def sumFirstNumbersHelper(upUntil: Int, accumulator: Int): Int =
        if upUntil < 0 then
            throw new IllegalArgumentException("negative number")
        upUntil match
            case 0 => accumulator
            case n => sumFirstNumbersHelper(n - 1, n + accumulator)

    def factorial(input: Int): Long = 
        if input < 0 then
            throw new IllegalArgumentException("negative number")
        input match
            case 0 => 1
            case n => n * factorial(n-1)
        

    def replicate[T](length: Int, element: T): List[T] =
        if length < 0 then
            throw new IllegalArgumentException("negative number")
        length match
            case 0 => List()
            case n => List(element) ::: replicate(n-1, element)
        

    def sumArray(array: List[Int]): Int =
        array match 
            case Nil => 0
            case head :: next => array(0) + sumArray(next)

    def isElementOf[T](elementToCheck: T, array: List[T]): Boolean = 
        array match
            case Nil => false
            case head :: next => 
                if array(0).equals(elementToCheck) then true
                else isElementOf(elementToCheck, next)

    def range(upTo: Int): List[Int] = 
        if upTo < 1 then List()
        else range(upTo-1) ::: List(upTo-1) 
        

    def concatenate[T](firstArray: List[T], secondArray: List[T]): List[T] = 
        secondArray match
            case Nil => firstArray
            case head :: next => concatenate(firstArray :+ secondArray(0), next)

    def reverse[T](array: List[T]): List[T] = 
        array match
            case Nil => array
            case head :: next => reverse(next) :+ head

    def getElement[T](array: List[T], index: Int): T =
        if index < 0 || index > array.length then
            throw new IndexOutOfBoundsException()
        if index == 0 then 
            array(0)
        else array match
            case Nil => throw new IndexOutOfBoundsException()
            case head :: next => getElement(next, index-1)
        
