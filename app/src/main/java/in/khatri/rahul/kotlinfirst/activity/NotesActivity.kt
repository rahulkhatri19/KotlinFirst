package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.model.Notes
import `in`.khatri.rahul.kotlinfirst.utility.DatabaseHelperNotes
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notes.*
import kotlinx.android.synthetic.main.notes_item.view.*

class NotesActivity : AppCompatActivity() {

    var notesList = ArrayList<Notes>()
    var adapter: NotesAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        adapter = NotesAdapter(this, notesList)
        getData()
        fab_add.setOnClickListener {
            startActivity(Intent(this, NotesAddActivity::class.java))
        }
//        notesList.add(
//            Notes(
//                1,
//                "Written By Me",
//                "By now, you have a winning strategy for how you will use content to grow your business… an effective idea-generating system in place… and an editorial plan for the content you'll create over the next few months, give or take."
//            )
//        )
//
//        notesList.add(
//            Notes(
//                2,
//                "Written By Neil Patel",
//                "Just to be clear: In this chapter, we talk primarily about how to write content. That doesn't mean we think you ought to be creating blog posts only or that written content is somehow better."
//            )
//        )
//
//        notesList.add(
//            Notes(
//                3,
//                "Written By Kathryn Aragon",
//                "If you've studied writing, you may recognize this as the writing process. We've renamed it the creative process on purpose."
//            )
//        )

//        lv_notes.adapter = NotesAdapter(this, notesList)
    }

    private fun getData() {
//        val arrayListData = ArrayList<Notes>()
        val dbHandler = DatabaseHelperNotes(this, null)
        val cursor = dbHandler.getData()
        cursor!!.moveToFirst()
        notesList.add(
            Notes(
                cursor.getString(cursor.getColumnIndex(DatabaseHelperNotes.colID)).toInt(),
                cursor.getString(cursor.getColumnIndex(DatabaseHelperNotes.colTitle)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelperNotes.colDes))
            )
        )

        while (cursor.moveToNext()) {
            notesList.add(
                Notes(
                    cursor.getString(cursor.getColumnIndex(DatabaseHelperNotes.colID)).toInt(),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelperNotes.colTitle)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelperNotes.colDes))
                )
            )
        }
        cursor.close()
        lv_notes.adapter = NotesAdapter(this, notesList)
    }

    inner class NotesAdapter : BaseAdapter {
        var list = ArrayList<Notes>()
        var context: Context? = null

        constructor(mContext: Context, mList: ArrayList<Notes>) : super() {
            this.context = mContext
            this.list = mList
        }

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val notes = list[position]
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val myView = inflater.inflate(R.layout.notes_item, null)

            myView.tv_title.text = notes.title!!
            myView.tv_content.text = notes.content!!
            myView.iv_edit.setOnClickListener {
                //                val dbHandler= DatabaseHelperNotes(context!!, null)
//                dbHandler.updateData()
                Log.e("edit", "id: ${notes.notesId}")
            }
            myView.iv_delete.setOnClickListener {
                delete(position)
                val dbHandler = DatabaseHelperNotes(context!!, null)
                dbHandler.deleteData(notes.notesId!!.toInt())

            }

//            myView.ll_food.setOnClickListener {
//                context!!.startActivity(
//                    Intent(context, RestaurantDetailActivity::class.java).putExtra("name", food.name!!).putExtra(
//                        "des",
//                        food.des!!
//                    ).putExtra(
//                        "image",
//                        food.image!!
//                    )
//                )
//            }
            return myView
        }

        override fun getItem(position: Int): Any {
            return list[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return list.size
        }

    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun delete(index: Int) {
        notesList.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
}
