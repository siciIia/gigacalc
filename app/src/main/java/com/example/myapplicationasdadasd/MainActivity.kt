package com.example.myapplicationasdadasd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var allString = ""
    private var lastop: String? = null
    private lateinit var button: Button
    private lateinit var textview: TextView
//    "896+7".split("+") -> ["896", "7"]
    private var isDotWritten = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyLogMAct", "onCreate")

        textview = findViewById(R.id.infootvet)

        setButtonOnClickListener(R.id.button1, "1")
        setButtonOnClickListener(R.id.button2, "2")
        setButtonOnClickListener(R.id.button3, "3")
        setButtonOnClickListener(R.id.b4, "4")
        setButtonOnClickListener(R.id.b5, "5")
        setButtonOnClickListener(R.id.b6, "6")
        setButtonOnClickListener(R.id.b7, "7")
        setButtonOnClickListener(R.id.b8, "8")
        setButtonOnClickListener(R.id.b9, "9")
        setButtonOnClickListener(R.id.b0, "0")
        button = findViewById(R.id.clear)
        button.setOnClickListener {
            lastop = null
            allString = ""
            textview.text = allString
        }
        button = findViewById(R.id.removelast)
        button.setOnClickListener {
            allString = allString.dropLast(1)
            textview.text = allString
        }
        button = findViewById(R.id.resetApp)
        button.setOnClickListener {
            finishAffinity()
        }
        button = findViewById(R.id.WOW)
        button.setOnClickListener {
            lastop = "*"
            fillStroke("*")
        }

        button = findViewById(R.id.delim)
        button.setOnClickListener {
            lastop = "/"
            fillStroke("/")
        }

        button = findViewById(R.id.minus)
        button.setOnClickListener {
            lastop = "-"
            fillStroke("-")
        }

        button = findViewById(R.id.plus)
        button.setOnClickListener {
            lastop = "+"
            fillStroke("+")
        }
        button = findViewById(R.id.equa)
        button.setOnClickListener {
            if (lastop != null) {
                val array = allString.split(lastop!!)
                val num1 = array[0]
                val num2 = array[1]
                when (lastop){
                    "+" -> {
                        if (isDotWritten) { // .toDouble()
                            val result = num1.toDouble() + num2.toDouble()
                            allString = result.toString()
                            textview.text = allString
                        } else { // .toInt()
                            val result = num1.toInt() + num2.toInt()
                            allString = result.toString()
                            textview.text = allString
                        }
                    }
                    "-" -> {
                        if (isDotWritten) { // .toDouble()
                            val result = num1.toDouble() - num2.toDouble()
                            allString = result.toString()
                            textview.text = allString
                        } else { // .toInt()
                            val result = num1.toInt() - num2.toInt()
                            allString = result.toString()
                            textview.text = allString
                        }
                    }
                    "*" -> {
                        if (isDotWritten) {
                            val result = num1.toDouble() * num2.toDouble()
                            allString = result.toString()
                            textview.text = allString
                        } else {
                            val result = num1.toInt() * num2.toInt()
                            allString = result.toString()
                            textview.text = allString
                    }

                    }
                    "/" -> {
                    if (isDotWritten) {
                            val result = num1.toDouble() / num2.toDouble()
                            allString = result.toString()
                        textview.text = allString
                    } else {
                            val result = num2.toInt() / num2.toInt()
                            allString = result.toString()
                            textview.text = allString
                    }

                    }

            }
        }

        button = findViewById(R.id.dot)
        button.setOnClickListener {
            isDotWritten = true
            lastop = "."
            allString += "."
            textview.text = allString
        }
//        button = findViewById(R.id.proc)
//        button.setOnClickListener {
//            if (lastop == null) {
//                numberOne = numberOne / 100
//                textview.text = numberOne.toString()
//            } else {
//                numberTwo = numberTwo / 100
//                textview.text = numberTwo.toString()
//            }
//        }
        }
    }

    private fun setButtonOnClickListener(buttonId: Int, number: String) {
        button = findViewById(buttonId)
        button.setOnClickListener {
            fillStroke(number)
        }
    }

    private fun fillStroke(number: String) {
        allString += number
        textview.text = allString
    }


}
// 30 (num1) - 10 (num2) %
// 10% == 30(num1) / 100  * 10(num2)
