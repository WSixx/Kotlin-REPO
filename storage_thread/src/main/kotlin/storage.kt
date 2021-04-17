import java.io.FileReader
import java.io.FileWriter

fun main(args: Array<String>) {

    writeToFile("Ana")

    readFromFile()

}

fun writeToFile(str:String){
    try {
        var fo=FileWriter("name.txt", true)
        fo.write(str + "\n")
        fo.close()
    }catch (ex:Exception){
        println(ex.message)
    }
}

fun readFromFile(){
    try {
        var fin=FileReader("name.txt")
        var c:Int?
        do {
            c = fin.read()
            print(c.toChar())
        }while (c!= -1)
    }catch (ex:Exception){
        println(ex.message)
    }
}