package com.example.kotlincalculator

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var plusMinus: Button
    private lateinit var decimal: Button
    private lateinit var multiply: Button
    private lateinit var divide: Button
    private lateinit var add: Button
    private lateinit var subtract: Button
    private lateinit var clear: Button
    private lateinit var result: Button
    private lateinit var del: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        display = findViewById(R.id.tvDisplay)

        display.text = viewModel.displayText

        zero = findViewById(R.id.bt0)
        zero.setOnClickListener { viewModel.setNum('0'); display.text = viewModel.displayText }
        one = findViewById(R.id.bt1)
        one.setOnClickListener { viewModel.setNum('1'); display.text = viewModel.displayText }
        two = findViewById(R.id.bt2)
        two.setOnClickListener { viewModel.setNum('2'); display.text = viewModel.displayText }
        three = findViewById(R.id.bt3)
        three.setOnClickListener { viewModel.setNum('3'); display.text = viewModel.displayText }
        four = findViewById(R.id.bt4)
        four.setOnClickListener { viewModel.setNum('4'); display.text = viewModel.displayText }
        five = findViewById(R.id.bt5)
        five.setOnClickListener { viewModel.setNum('5'); display.text = viewModel.displayText }
        six = findViewById(R.id.bt6)
        six.setOnClickListener { viewModel.setNum('6'); display.text = viewModel.displayText }
        seven = findViewById(R.id.bt7)
        seven.setOnClickListener { viewModel.setNum('7'); display.text = viewModel.displayText }
        eight = findViewById(R.id.bt8)
        eight.setOnClickListener { viewModel.setNum('8'); display.text = viewModel.displayText }
        nine = findViewById(R.id.bt9)
        nine.setOnClickListener { viewModel.setNum('9'); display.text = viewModel.displayText }
        add = findViewById(R.id.btPlus)
        add.setOnClickListener { viewModel.handleOperator('+'); display.text = viewModel.displayText }
        subtract = findViewById(R.id.btMinus)
        subtract.setOnClickListener { viewModel.handleOperator('-'); display.text = viewModel.displayText }
        multiply = findViewById(R.id.btMultiply)
        multiply.setOnClickListener { viewModel.handleOperator('*'); display.text = viewModel.displayText }
        divide = findViewById(R.id.btDiv)
        divide.setOnClickListener { viewModel.handleOperator('/'); display.text = viewModel.displayText }
        decimal = findViewById(R.id.btDecimal)
        decimal.setOnClickListener { viewModel.onClickDecimal(); display.text = viewModel.displayText }
        plusMinus = findViewById(R.id.btNegative)
        plusMinus.setOnClickListener { viewModel.onClickPlusMinus(); display.text = viewModel.displayText }
        clear = findViewById(R.id.btClear)
        clear.setOnClickListener { viewModel.clearAll(); display.text = viewModel.displayText }
        result = findViewById(R.id.btEquals)
        result.setOnClickListener { viewModel.calculate(); display.text = viewModel.displayText }
        del = findViewById(R.id.btDel)
        del.setOnClickListener { viewModel.deleteLast(); display.text = viewModel.displayText }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            display.setPadding(0,0,24,0)
            display.textSize = 24f
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            display.setPadding(0,24,24,0)
            display.textSize = 32f
        }
    }
}