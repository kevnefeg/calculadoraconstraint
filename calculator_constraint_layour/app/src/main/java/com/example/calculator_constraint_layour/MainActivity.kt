package com.example.calculator_constraint_layour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var num1: Double = 0.0
    var num2: Double = 0.0
    var operation: Int = 0
    var resultTV: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var divBtn: Button = findViewById(R.id.divisionBtn)
        var multiplicationBtn: Button = findViewById(R.id.multiplicationBtn)
        var substractBtn: Button = findViewById(R.id.substractionBtn)
        var additionBtn: Button = findViewById(R.id.additionBtn)
        var cleanBtn: Button = findViewById(R.id.cleanBtn)
        var equalBtn: Button = findViewById(R.id.equalBtn)

        resultTV = findViewById(R.id.resultTextView)
        divBtn.setOnClickListener { operationPressed(1) }
        multiplicationBtn.setOnClickListener { operationPressed(2) }
        substractBtn.setOnClickListener { operationPressed(3) }
        additionBtn.setOnClickListener { operationPressed(4) }

        cleanBtn.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultTV?.text = "0"
            operation = 0
        }

        equalBtn.setOnClickListener {
            var result = 0.0

            if (operation == 1) result = num1 / num2
            else if (operation == 2) result = num1 * num2
            else if (operation == 3) result = num1 - num2
            else if (operation == 4) result = num1 + num2

            resultTV?.text = result.toString()
            operation = 0
        }
    }

    fun resultCalculated(view: View){

        var button = view as Button
        var buttonText = button.text.toString()
        resultTV?.text = "${resultTV?.text}$buttonText"

        if (operation == 0){
            num1 = resultTV?.text.toString().toDouble()
            System.out.println(num1)
        }
        else{
            num2 = resultTV?.text.toString().toDouble()
            System.out.println(num2)
        }


        deleteZeros(resultTV?.text as String)
    }

    fun operationPressed(operation: Int){
        this.operation = operation

        resultTV?.text = "0"
    }

    fun deleteZeros(str: String): CharSequence? {
        var i = 0
        while (i < str.length && str[i]=='0')i++
        val sb = StringBuffer(str)
        sb.replace(0,i,"")
        resultTV?.text = sb.toString()
        return  resultTV?.text
    }
}