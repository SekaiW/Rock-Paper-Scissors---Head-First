// This project is based off of Chapter 3 in O'Reilly's Head First Kotlin by Dawn and David Griffiths

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
} // end of main

// game choice is randomized
fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

// prompting user for their choice
fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = " "
    println("What's your pick?")
    while(!isValidChoice) {
        for (i in optionsParam) {
            print(" $i" )
        }
        print(": ")
        val userInput = readlnOrNull()
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) { // invalid user input
            println("Pick one of the three...")
        }
    }
    return userChoice
} // end of getUserChoice

// outputting the results
fun printResult(userChoice: String, gameChoice: String) {
    val result: String = when {
        userChoice == gameChoice -> { // tie
            "It's a tie :/"
        }
        // user wins
        userChoice == "Paper" && gameChoice == "Rock" ||
                userChoice == "Scissors" && gameChoice == "Paper" ||
                userChoice == "Rock" && gameChoice == "Scissors" -> {
            "You win >:("
                }
        else -> { // game loses
            "I win :)"
        }
    }

    // game's final words
    println("I picked $gameChoice and you picked $userChoice, so... $result")
} // end of printResult
