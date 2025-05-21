package composingSuspendingFunctions
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/*
fun main(args: Array<String>) = runBlocking {  // create a blocking coroutine that execute in current thread.
    println("Main program starts: ${Thread.currentThread().name}")  // main thread.

    val time =  measureTimeMillis {
        // code ...
        val msgOne: Deferred<String> = async {
            // code ...
            getMessageOne()
        }
        val msgTwo: Deferred<String> = async {
            // code ...
            getMessageTwo()
        }
        println("The message is: ${msgOne.await() + msgTwo.await()}")
    }
    println("Completed in $time ms")

    println("Main program ends: ${Thread.currentThread().name}")  // main thread.
}

suspend fun getMessageOne(): String {
    delay(1000L)
    return "Hello "
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    return "World!"
}
*/



