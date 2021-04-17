fun main(args: Array<String>) {
    println("Enter")

    try {
        var n2:Int= readLine()!!.toInt()
        var div=100/n2
        println("Div: $div")
    }catch (ex:Exception){
        println(ex.message)
    }

    println("Is done")
}