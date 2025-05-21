package timeOutCoroutines
import kotlinx.coroutines.*

/*
fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")
    val result = withTimeout(2000) {
        for (i in 0..500) {
            print("$i.")
            delay(500)
        }
    }
    println("Main program ends: ${Thread.currentThread().name}")
}
*/

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")
    val result: String? = withTimeoutOrNull(2000) {
        for (i in 0..500) {
            print("$i.")
            delay(500)
        }
        "I am done"
    }
    println("Result: $result")
    println("Main program ends: ${Thread.currentThread().name}")
}