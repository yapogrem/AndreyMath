package com.example.andreymath

const val UPPER = 20
const val LOWER = 4

class ArithmeticTaskImpl:ArithmeticTask {
    override fun getTask(): Task {
        val firstDigit = getFirstDigit()
        val operand = Operations.getOperation((0..1).random())
        val secondDigit = getSecondDigit(firstDigit, operand)
        return Task(operand, firstDigit, secondDigit)
    }

    override fun check(input: Int, task: Task): Boolean {
        return when (task.operation) {
            Operations.PLUS -> task.firstDigit + task.secondDigit == input
            Operations.MINUS -> task.firstDigit - task.secondDigit == input
        }
    }


    private fun getFirstDigit(): Int = (LOWER..UPPER).random()

    private fun getSecondDigit(firstDigit: Int, operand: Operations): Int {
        return when (operand) {
            Operations.PLUS -> (2..UPPER - firstDigit).random()
            Operations.MINUS -> (2..< firstDigit).random()
        }
    }
}