package `in`.khatri.rahul.kotlinfirst.utility

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHelperNotes(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, dbName, null, dbVersion) {
    companion object {
        val dbName = "MyNotes.db"
        val dbTableName = "Notes"
        val colID = "ID"
        val colTitle = "Title"
        val colDes = "Description"
        val dbVersion = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateTable = "CREATE TABLE $dbTableName($colID INTEGER PRIMARY KEY,$colTitle TEXT,$colDes TEXT);"
//        val sqlCreateTable = "CREATE TABLE " + dbTableName + "(" + colID + " INTEGER PRIMARY KEY," + colTitle + " TEXT," + colDes + " TEXT);"
        db!!.execSQL(sqlCreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $dbTableName")
        onCreate(db)
    }

    fun insertData(title: String, des: String) {
        val values = ContentValues()
        values.put(colTitle, title)
        values.put(colDes, des)
        val db = this.writableDatabase
        db.insert(dbTableName, null, values)
        db.close()
    }

    fun getData(): Cursor?{
        val db= this.readableDatabase
        return db.rawQuery("SELECT * FROM $dbTableName", null)
    }
}
