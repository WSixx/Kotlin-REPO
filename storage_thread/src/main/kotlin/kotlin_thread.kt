fun main() {
    var t1 = UserThread("Thread 1")
    t1.start()
    var t2 = UserThread("Thread 2")
    t2.start()
    var t3 = UserThread("Thread 3")
    t3.start()
}

class UserThread(): Thread() {
    private var threadName: String = ""
    constructor(threadName: String): this(){
        this.threadName = threadName
    }
    override  fun run(){
        var count=0
        while (count<10){
            println("$threadName Count: $count")
            count++
            try {
                Thread.sleep(1000)
            }catch (ex:Exception){
                println(ex.message)
            }
        }
    }

}