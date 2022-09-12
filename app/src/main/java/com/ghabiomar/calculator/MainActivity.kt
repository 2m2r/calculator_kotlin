package com.ghabiomar.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)


        btnClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        btnDelete.setOnClickListener {

            var str :String = input.text.toString()
            if (str != "") {
                str = str.substring(0, str.length - 1)
                input.text = str
                output.text = ""
            }

        }
        btnBrace1.setOnClickListener {
            input.text= (input.text.toString()+")")
        }
        btnBrace2.setOnClickListener {
            input.text= (input.text.toString()+"(")
        }
        btn1.setOnClickListener {
            input.text= (input.text.toString()+"1")
        }
        btn2.setOnClickListener {
            input.text= (input.text.toString()+"2")
        }
        btn3.setOnClickListener {
            input.text= (input.text.toString()+"3")
        }
        btn4.setOnClickListener {
            input.text= (input.text.toString()+"4")
        }
        btn5.setOnClickListener {
            input.text= (input.text.toString()+"5")
        }
        btn6.setOnClickListener {
            input.text= (input.text.toString()+"6")
        }
        btn7.setOnClickListener {
            input.text= (input.text.toString()+"7")
        }
        btn8.setOnClickListener {
            input.text= (input.text.toString()+"8")
        }
        btn9.setOnClickListener {
            input.text= (input.text.toString()+"9")
        }
        btnZr.setOnClickListener {
            input.text= (input.text.toString()+"0")
        }
        btnPt.setOnClickListener {
            input.text= (input.text.toString()+".")
        }
        btnPerCe.setOnClickListener {
            input.text= (input.text.toString()+"%")

        }
        btnSin.setOnClickListener {
            /* if (input.text.toString().isEmpty()){
               Toast.makeText(this,"Please Enter a valid number",Toast.LENGTH_SHORT).show()
             } else{
                 val str :String = input.text.toString()
                 val r = sin(str.toDouble())
                 val result = r .toString()
                 input.text = (input.text.toString()+"sin(")
                 output.text = result }*/
            input.text= (input.text.toString()+"sin(")
        }
        btnCos.setOnClickListener {
            input.text= (input.text.toString()+"cos(")
        }
        btnEq.setOnClickListener {
            if (input.text.toString().isEmpty()){
                input.text = ""
                output.text = ""

            } else {
                showResult()
            }

        }
        btnAdd.setOnClickListener {

            if (input.text.toString().isEmpty()){
                input.text = ""
                output.text = ""

            } else {
                input.text = (input.text.toString() + "+")
            }

        }
        btnMin.setOnClickListener {

            input.text= (input.text.toString()+"-")

        }
        btnMul.setOnClickListener {
            if (input.text.toString().isEmpty()){
                input.text = ""
                output.text = ""

            } else {
                input.text = (input.text.toString() + "×")
            }

        }
        btnDiv.setOnClickListener {
            if (input.text.toString().isEmpty()){
                input.text = ""
                output.text = ""

            } else {
                input.text = (input.text.toString() + "÷")
            }
        }


    }
    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }
    private fun getInputExpression():String{
        var expression = input.text.replace(Regex("÷") ,"/")
        expression = input.text.replace(Regex("×"),"*")
        return expression
    }
    private fun showResult(){
        try {
            val expression  = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.output_color))
            } else {
                // Show Result
                output.text = DecimalFormat("0.########").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.output_color))
            }

        } catch (e:Exception) {
            // show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.output_color))
        }
    }
}