package com.example.andreymath

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


    private fun getFirstDigit(): Int = (5..10).random()

    private fun getSecondDigit(firstDigit: Int, operand: Operations): Int {
        return when (operand) {
            Operations.PLUS -> (0..10 - firstDigit).random()
            Operations.MINUS -> (0..firstDigit).random()
        }
    }
}