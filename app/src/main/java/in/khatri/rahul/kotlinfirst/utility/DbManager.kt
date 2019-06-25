package `in`.khatri.rahul.kotlinfirst.utility

class DbManager {

    val dbName="MyNotes"
    val dbTableName="Notes"
    val colID="ID"
    val colTitle= "Title"
    val colDes= "Description"
    val dbVersion="1"
    val sqlCreateTable= "CREATE TABLE IF NOT EXISTS $dbName "
}