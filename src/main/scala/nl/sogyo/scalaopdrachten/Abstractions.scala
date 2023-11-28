package nl.sogyo.scalaopdrachten

object Abstractions:

    def map[A, B](array: List[A], function: A => B): List[B] =
        array match
            case Nil => Nil
            case head :: next => List(function(head)) ::: map(next, function)

    def filter[A](array: List[A], predicate: A => Boolean): List[A] = 
        array match
            case Nil => Nil
            case head :: next => {
                if predicate(head) then List(head) ::: filter(next, predicate)
                else filter(next, predicate)
            }

    def forEach[A](array: List[A], action: A => Unit): Unit = 
        array match
            case Nil => 
            case head :: Nil => action(head)
            case head :: next => {
                action(head)
                forEach(next, action)
            }

    def reduce[A](array: List[A], operation: (A, A) => A): A = 
        array match
            case Nil => throw new IllegalArgumentException()
            case head :: Nil => head
            case head :: next => operation(head, reduce(next, operation))

    def zipWith[A, B, C](
        firstArray: List[A],
        secondArray: List[B],
        function: (A, B) => C
    ): List[C] = 
        (firstArray, secondArray) match
            case (firstHead :: firstNext, secondHead :: secondNext) => function(firstHead, secondHead) :: zipWith(firstNext, secondNext, function)
            case _ => Nil
        