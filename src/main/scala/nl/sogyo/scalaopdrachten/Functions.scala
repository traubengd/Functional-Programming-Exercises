package nl.sogyo.scalaopdrachten

object Functions:

    def compose[A, B, C](f: A => B, g: B => C)(a: A): C =
        g(f(a))

    def curry[A, B, C](f: (A, B) => C)(a: A)(b: B): C = 
        f(a, b)

    def flip[A, B, C](f: (A, B) => C)(b: B, a: A): C = 
        f(a, b)

    def isDivisibleBy(x: Int, n: Int): Boolean = x % n == 0

    val isDivisibleBySwappedArguments = curry(flip(isDivisibleBy))
