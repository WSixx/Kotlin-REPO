package br.com.lucad.zooapp

class Animal(name:String, description: String, image: Int) {
    var name:String?=null
    var description:String?=null
    var image:Int?=null
    init {
        this.name = name
        this.description = description
        this.image = image
    }
}