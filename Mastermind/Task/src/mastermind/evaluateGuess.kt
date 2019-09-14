package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secret_state = intArrayOf(0, 0, 0, 0)
    var guess_state = intArrayOf(0, 0, 0, 0)
    var rightCount = 0
    var wrongCount = 0

    for (i in 0..3) {
        if (guess[i] == secret[i]) {
            rightCount++
            guess_state[i] = 1
            secret_state[i] = 1
        }
    }
    for (i in 0..3) {
        for (j in 0..3) {
            if (secret_state[i] == 0 && guess_state[j] == 0 && secret[i] == guess[j]) {
                wrongCount++
                guess_state[j] = 1
                break
            }
        }
    }

    return Evaluation(rightCount, wrongCount)
}
