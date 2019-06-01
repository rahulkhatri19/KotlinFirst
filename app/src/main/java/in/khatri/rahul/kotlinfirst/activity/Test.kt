package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
       // btnFindAge.text="Find Age"
        /*btnFindAge.setOnClickListener {
            val yearOfBirth: Int= et_dob.text.toString().toInt()
            val myAge= 2018 - yearOfBirth
            tv_show_age.text= "Your Age is $myAge years"
        }*/
    }
    fun myAge(view: View){
        val yearOfBirth: Int= et_dob.text.toString().toInt()
        val myAge= 2019 - yearOfBirth
        tv_show_age.text= "Your Age is $myAge years"
    }
}
