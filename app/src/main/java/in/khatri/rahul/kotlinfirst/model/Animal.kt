package `in`.khatri.rahul.kotlinfirst.model

class Animal{
    var name: String?=null
    var des: String?= null
    var image: Int?= null
    var killer: Boolean?= false

    constructor(name: String?, des: String?, image: Int?, killer:Boolean?) {
        this.name = name
        this.des = des
        this.image = image
        this.killer= killer
    }
}