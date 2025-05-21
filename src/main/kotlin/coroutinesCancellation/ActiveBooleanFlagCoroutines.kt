package coroutinesCancellation
import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    // create a blocking coroutine that execute in current thread (main).
    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) {
                // break
                return@launch
            }
            print("$i.")
            Thread.sleep(1)
        }
    }

    delay(10)  // let's print few value before coroutines get cancelled.
    job.cancelAndJoin()

    println("\nMain program ends: ${Thread.currentThread().name}")
}