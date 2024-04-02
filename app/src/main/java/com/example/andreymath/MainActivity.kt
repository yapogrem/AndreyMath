package com.example.andreymath

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {

    private lateinit var inputEditDigit: EditText
    private lateinit var firstDigitView: TextView
    private lateinit var secondDigitView: TextView
    private lateinit var operandView: TextView
    private lateinit var newTaskButton: Button
    private lateinit var statsButton: Button
    private lateinit var placeholderCorrectAnswer: TextView
    private lateinit var placeholderWrongAnswer: TextView
    private lateinit var serviceArithmetic: ArithmeticTask
    private lateinit var currentTask: Task


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        serviceArithmetic = ArithmeticTaskImpl()


        inputEditDigit = findViewById(R.id.input_search)
        firstDigitView = findViewById(R.id.first_digit)
        secondDigitView = findViewById(R.id.second_digit)
        operandView = findViewById(R.id.operand)
        newTaskButton = findViewById(R.id.new_task_button)
        statsButton = findViewById(R.id.stats_button)
        placeholderCorrectAnswer = findViewById(R.id.correct_answer)
        placeholderWrongAnswer = findViewById(R.id.wrong_answer)

        inputEditDigit.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val input = inputEditDigit.text.toString().toInt()
                if(serviceArithmetic.check(input,currentTask)){
                    showCorrectAnswer()
                    SaveStatistic.correctAnswer += 1
                }else{
                    showWrongAnswer()
                    SaveStatistic.wrongAnswer += 1
                }
            }
            false
        }

        statsButton.setOnClickListener {
            val displayIntent = Intent(this, StatisticActivity::class.java)
            startActivity(displayIntent)
        }

        newTaskButton.setOnClickListener {
            newTask()
        }

        newTask()
    }


    private fun newTask() {
        showNewTask()
        currentTask = serviceArithmetic.getTask()
        firstDigitView.text = currentTask.firstDigit.toString()
        secondDigitView.text = currentTask.secondDigit.toString()
        inputEditDigit.setText("")
        when(currentTask.operation) {
            Operations.PLUS -> operandView.text = "+"
            Operations.MINUS -> operandView.text = "-"
        }
    }

    private fun showCorrectAnswer() {
        placeholderCorrectAnswer.isVisible = true
        placeholderWrongAnswer.isVisible = false
        newTaskButton.isVisible = true
        statsButton.isVisible = true
    }

    private fun showWrongAnswer() {
        placeholderCorrectAnswer.isVisible = false
        placeholderWrongAnswer.isVisible = true
        newTaskButton.isVisible = true
        statsButton.isVisible = true
    }

    private fun showNewTask() {
        placeholderCorrectAnswer.isVisible = false
        placeholderWrongAnswer.isVisible = false
        newTaskButton.isVisible = false
        statsButton.isVisible = false

    }
}