package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_calculator.view.*

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        btn_ce.setOnClickListener {
            tv_show_calculation.text = "0"
            isNewOp=true
        }
        btn_percent.setOnClickListener {
            val number: Double=tv_show_calculation.text.toString().toDouble()/100
            tv_show_calculation.text = number.toString()
            isNewOp=true
        }
        btn_xSquare.setOnClickListener {
            val number: Double= tv_show_calculation.text.toString().toDouble()*tv_show_calculation.text.toString().toDouble()
            tv_show_calculation.text = number.toString()
            isNewOp=true
        }
    }
    fun btnNumEvent(view: View){
        if (isNewOp==true){
            tv_show_calculation.text = "0"
        }
        isNewOp=false
        val btnSelect= view as Button
        var btnClickValue:String=tv_show_calculation.text.toString()
        when(btnSelect.id){
            btn_ce.id -> tv_show_calculation.hint = "0"
            btn_7.id -> btnClickValue+="7"
            btn_8.id -> btnClickValue+="8"
            btn_9.id -> btnClickValue+="9"
            btn_4.id -> btnClickValue+="4"
            btn_5.id -> btnClickValue+="5"
            btn_6.id -> btnClickValue+="6"
            btn_1.id -> btnClickValue+="1"
            btn_2.id -> btnClickValue+="2"
            btn_3.id -> btnClickValue+="3"
            btn_sign.id -> btnClickValue="-"+btnClickValue
            btn_0.id -> btnClickValue+="0"
            btn_dot.id -> btnClickValue+="."
        }
        tv_show_calculation.text = btnClickValue
    }
    var op="*"
    var oldNumber=""
    var isNewOp=true
    fun onOptionEvent(view: View){
        val btnSelect= view as Button
        var  btnClickValue:String=tv_show_calculation.text.toString()
        when(btnSelect.id){
            btn_divide.id -> op="/"
            btn_multiply.id -> op="*"
            btn_minus.id -> op="-"
            btn_addition.id -> op="+"

        }
        oldNumber=tv_show_calculation.text.toString()
        isNewOp=true
    }

    fun equalEvent(view: View){
        val newNumber=tv_show_calculation.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*" -> finalNumber= oldNumber.toDouble() * newNumber.toDouble()
            "/" -> finalNumber= oldNumber.toDouble() / newNumber.toDouble()
            "+" -> finalNumber= oldNumber.toDouble() + newNumber.toDouble()
            "-" -> finalNumber= oldNumber.toDouble() - newNumber.toDouble()
        }
        tv_show_calculation.text = finalNumber.toString()
        isNewOp=true
    }

}
