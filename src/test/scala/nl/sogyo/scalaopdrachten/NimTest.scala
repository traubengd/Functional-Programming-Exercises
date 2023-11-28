package nl.sogyo.scalaopdrachten

import Nim.*

class NimTest extends munit.FunSuite:

    test("Computer being given less than 11 but more than 6 matches results in it returning 6 matches"){
        assertEquals(removeMatchesByComputer(10), 6)
        assertEquals(removeMatchesByComputer(9), 6)
        assertEquals(removeMatchesByComputer(8), 6)
        assertEquals(removeMatchesByComputer(7), 6)
    }

    test("Computer being given less than 6 but more than 1 matches results in it returning 1 match"){
        assertEquals(removeMatchesByComputer(5), 1)
        assertEquals(removeMatchesByComputer(4), 1)
        assertEquals(removeMatchesByComputer(3), 1)
        assertEquals(removeMatchesByComputer(2), 1)
    }

    test("When there are no matches remaining, the player whose turn it is next is declared as winner"){
        assertEquals(checkNumberOfMatches(0, 1, Player.Player1), Player.Player1)
    }

    test("If the current player is the computer the next player is player 1"){
        assertEquals(computerTurn(1), Player.Player1)
    }

    test("Returning correct next player after player 1, based on amount of players"){
        assertEquals(determinePlayerAfterOne(1), Player.Computer)
        assertEquals(determinePlayerAfterOne(2), Player.Player2)
    }