package `in`.khatri.rahul.kotlinfirst.model

class Notes {
    var notesId:Int? = null
    var title:String? = null
    var content:String? = null

    constructor(notesId:Int, title:String, content:String ){
        this.notesId= notesId
        this.title= title
        this.content= content
    }
}