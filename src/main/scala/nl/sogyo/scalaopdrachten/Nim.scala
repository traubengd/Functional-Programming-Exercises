package nl.sogyo.scalaopdrachten

import scala.io.StdIn.readLine
import Math.{min, max}

object Nim:
    enum Player (name : String):
        def getName(): String =
            this.name
        case Player1 extends Player("Player 1")
        case Player2 extends Player("Player 2")
        case Computer extends Player("Computer Player")

    def inputNumberOfPlayers(userInput : Int): Int =
        userInput match
            case x if x < 1 || x > 2 => 
                println("Please enter a correct amount. ")
                inputNumberOfPlayers(getUserInputToInt("How many players? (1 or 2)"))
            case _ => userInput

    def checkNumberOfMatches(currentNumberOfMatches : Int, numberOfPlayers : Int, currentPlayer : Player): Player =
        println("There are " + currentNumberOfMatches + " matches left.")
        currentNumberOfMatches match
            case 0 => currentPlayer //return current player as winner
            case _ => processGameTurn(currentNumberOfMatches, numberOfPlayers, currentPlayer) //continue the game
    
    def processGameTurn(currentNumberOfMatches : Int, numberOfPlayers : Int, currentPlayer : Player):Player =
        currentPlayer match
            case Player.Computer => computerTurn(currentNumberOfMatches)
            case _ => playerTurn(currentNumberOfMatches, numberOfPlayers, currentPlayer)
    
    def computerTurn(currentNumberOfMatches : Int): Player =
        val matchesAfterRemoval = removeMatchesByComputer(currentNumberOfMatches)
        checkNumberOfMatches(matchesAfterRemoval, 1, Player.Player1)
    
    def playerTurn(currentNumberOfMatches : Int, numberOfPlayers : Int, currentPlayer : Player): Player =
        val userInput = getUserInputToInt(currentPlayer.getName() + "! How many matches do you want to take? (At most " + min(4,currentNumberOfMatches) + ")")
        val matchesAfterRemoval = removeMatches(currentNumberOfMatches, userInput)
        currentPlayer match
            case Player.Player1 => 
                val nextPlayer = determinePlayerAfterOne(numberOfPlayers)
                checkNumberOfMatches(matchesAfterRemoval, numberOfPlayers, nextPlayer)
            case _ => checkNumberOfMatches(matchesAfterRemoval, numberOfPlayers, Player.Player1)

    def determinePlayerAfterOne(numberOfPlayers : Int):Player =
        numberOfPlayers match
            case 1 => Player.Computer
            case 2 => Player.Player2
   
    def removeMatches(currentNumberOfMatches : Int, userInput : Int): Int =
        userInput match
            case x if x < 1 || x > 4 || x > currentNumberOfMatches =>
                println("Please choose a correct amount of matches.")
                val newUserInput = getUserInputToInt("How many matches do you want to take? (At most " + min(4,currentNumberOfMatches) + ")")
                removeMatches(currentNumberOfMatches, newUserInput)
            case _ => 
                currentNumberOfMatches - userInput
        
    def removeMatchesByComputer(currentNumberOfMatches : Int): Int =
        val computerPick = max(1, (currentNumberOfMatches - 1) % 5)
        println("The computer takes " + computerPick + " matches!")
        currentNumberOfMatches - computerPick
    
    def getUserInputToInt(prompt : String): Int =
        println(prompt)
        val input = readLine().toIntOption
        input match
            case None => 
                println("Please enter a number")
                getUserInputToInt(prompt)
            case Some(value) => value

    @main def main(): Unit =
        val startingNumberOfMatches = 11

        val numberOfPlayers = inputNumberOfPlayers(getUserInputToInt("How many players? (1 or 2)"))
        val winner = checkNumberOfMatches(startingNumberOfMatches, numberOfPlayers, Player.Player1)

        println(winner.getName() + " has won!")
