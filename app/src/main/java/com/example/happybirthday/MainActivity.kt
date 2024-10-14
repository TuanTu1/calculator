package com.example.happybirthday

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var display: TextView
    private var state: Int = 1
    private var op: Int = 0
    private var op1: Int = 0
    private var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Setting click listeners for buttons
        val buttonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnAdd, R.id.btnEqual
        )

        buttonIds.forEach { id ->
            findViewById<Button>(id)?.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn0 -> addDigit(0)
            R.id.btn1 -> addDigit(1)
            R.id.btn2 -> addDigit(2)
            R.id.btn3 -> addDigit(3)
            R.id.btn4 -> addDigit(4)
            R.id.btn5 -> addDigit(5)
            R.id.btn6 -> addDigit(6)
            R.id.btn7 -> addDigit(7)
            R.id.btn8 -> addDigit(8)
            R.id.btn9 -> addDigit(9)
            R.id.btnAdd -> {
                op = 1
                state = 2
            }
            R.id.btnEqual -> {
                var result = 0
                if (op == 1) {
                    result = op1 + op2
                }
                display.text = result.toString()
                resetCalculator()
            }
        }
    }

    private fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            display.text = op1.toString()
        } else {
            op2 = op2 * 10 + c
            display.text = op2.toString()
        }
    }

    private fun resetCalculator() {
        state = 1
        op1 = 0
        op2 = 0
        op = 0
    }
}