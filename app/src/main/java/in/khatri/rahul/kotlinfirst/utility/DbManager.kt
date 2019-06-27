package `in`.khatri.rahul.kotlinfirst.utility

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbManager {

    val dbName = "MyNotes"
    val dbTableName = "Notes"
    val colID = "ID"
    val colTitle = "Title"
    val colDes = "Description"
    val dbVersion = 1
    val sqlCreateTable = "CREATE TABLE IF NOT EXISTS $dbName ($colID INTEGER PRIMARY KEY,$colTitle TEXT, $colDes TEXT);"
    var sqlDB: SQLiteDatabase? = null

    constructor(context: Context) {
        val db = DatabaseHelperNotes(context)
        sqlDB = db.writableDatabase
    }

    inner class DatabaseHelperNotes : SQLiteOpenHelper {
        var context: Context? = null

        constructor(context: Context) : super(context, dbName, null, dbVersion) {
            this.context = context
        }

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context, "Database created", Toast.LENGTH_SHORT).show()
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("Drop table IF EXISTS $dbTableName")
        }
    }

    fun Insert(values: ContentValues): Long {
        val ID = sqlDB!!.insert(dbTableName, "", values)
        return ID
    }
}
