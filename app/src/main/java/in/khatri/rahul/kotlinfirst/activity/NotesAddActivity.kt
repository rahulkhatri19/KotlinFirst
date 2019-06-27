package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.utility.DbManager
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notes_add.*

class NotesAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_add)


        btn_add.setOnClickListener {
            Toast.makeText(this, "Title: " + et_title.text + "\nDescription: " + et_des.text, Toast.LENGTH_LONG).show()

        }
//        et_title.text
//        et_des.text
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.notes_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add_note -> {
                Toast.makeText(this, "Title: " + et_title.text + "\nDescription: " + et_des.text, Toast.LENGTH_LONG)
                    .show()
                addNotes(et_title.text.toString(), et_des.text.toString())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addNotes(title: String, des: String) {
        val dbManager = DbManager(this)
        var values = ContentValues()
        values.put("Title", title)
        values.put("Description", des)
        val ID = dbManager.Insert(values)
        if (ID > 0) Toast.makeText(this, "Note is been Inserted", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "Cant't add note", Toast.LENGTH_SHORT).show()

    }
}
