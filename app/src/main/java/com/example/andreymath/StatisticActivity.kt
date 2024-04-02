package com.example.andreymath
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class StatisticActivity : AppCompatActivity() {

    private lateinit var summaCorrectAnswers: TextView
    private lateinit var summaWrongAnswers: TextView
    private lateinit var summaAllAnswers: TextView
    private lateinit var refreshStatisticButton: Button
    private lateinit var buttonBack: ImageButton


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic)



        summaCorrectAnswers = findViewById(R.id.summa_correct_answers)
        summaWrongAnswers = findViewById(R.id.summa_wrong_answers)
        summaAllAnswers = findViewById(R.id.summa_all_answers)
        refreshStatisticButton = findViewById(R.id.refresh_statistic_button)
        buttonBack = findViewById(R.id.button_back)

        summaCorrectAnswers.text = SaveStatistic.correctAnswer.toString()
        summaWrongAnswers.text = SaveStatistic.wrongAnswer.toString()
        summaAllAnswers.text = (SaveStatistic.correctAnswer + SaveStatistic.wrongAnswer).toString()

        buttonBack.setOnClickListener {
            finish()
        }

        refreshStatisticButton.setOnClickListener {
            SaveStatistic.correctAnswer = 0
            SaveStatistic.wrongAnswer = 0
            summaCorrectAnswers.text = SaveStatistic.correctAnswer.toString()
            summaWrongAnswers.text = SaveStatistic.wrongAnswer.toString()
            summaAllAnswers.text = (SaveStatistic.correctAnswer + SaveStatistic.wrongAnswer).toString()
        }
    }
}