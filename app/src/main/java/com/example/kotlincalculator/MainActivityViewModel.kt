package com.example.kotlincalculator

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var output = 0f
    var operator = ' '
    var num1 = ""
    var num2 = ""

    var displayText = "0"

    fun onClickDecimal(){
        if(operator==' '&&!num1.contains(".")){setNum('.')}
        if(operator!=' '&&!num2.contains(".")){setNum('.')}
    }

    fun onClickPlusMinus(){
        if(operator==' '){
            num1 = if(num1.startsWith("-")){
                num1.substring(1, num1.length)
            } else{
                "-$num1"
            }
            displayText = num1
        }else{
            num2 = if(num2.startsWith("-")){
                num2.substring(1, num2.length)
            } else{
                "-$num2"
            }
            val text = num1 + operator + num2
            displayText = text
        }
    }

    fun setNum(num: Char){
        if(operator==' '){
            num1 += num
            displayText = num1
        }else{
            num2 += num
            val text = num1 + operator + num2
            displayText = text
        }
    }

    fun handleOperator(op: Char){
        operator = op
        val text = num1 + operator
        displayText = text
    }

    fun calculate(){
        var divByZero = false
        when (operator) {
            '+' -> output = num1.toFloat() + num2.toFloat()
            '-' -> output = num1.toFloat() - num2.toFloat()
            '*' -> output = num1.toFloat() * num2.toFloat()
            '/' -> if(num1.toFloat()!=0f&&num2.toFloat()!=0f){
                output = num1.toFloat() / num2.toFloat()
            }else{
                divByZero = true
            }
        }
        num1 = output.toString()
        num2 = ""
        displayText = output.toString()
        if(divByZero){clearAll()}
    }

    fun clearAll(){
        output = 0f
        operator = ' '
        num1 = ""
        num2 = ""
        displayText = "0"
    }

    fun deleteLast(){
        if(operator==' '){
            if(num1.isNotEmpty()){
                num1 = num1.substring(0, num1.length - 1)
                if(num1.isEmpty()){displayText = "0"}
                else{displayText = num1}
            }
        }else{
            if(num2.isNotEmpty()){
                num2 = num2.substring(0, num2.length - 1)
                val text = num1 + operator + num2
                displayText = text
            }else{
                operator=' '
                displayText = num1
            }
        }
    }
}