package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notes_add.*

class NotesAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_add)

        btn_add.setOnClickListener {
            Toast.makeText(this, "Title: "+et_title.text+"\nDescription: "+et_des.text,Toast.LENGTH_LONG).show()
        }

//        et_title.text
//        et_des.text
    }
}
