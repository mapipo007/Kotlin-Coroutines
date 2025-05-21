package coroutinesCancellation
import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    //  create a blocking coroutine that execute in current thread (main).
    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {
        try {
            for (i in 0..500) {
                print("$i.")
                delay(5)  // or use yield() or any other suspending function as per your need.
            }
        } catch (ex: CancellationException) {
            println("\nException caught safely: ${ex.message}")
        } finally {
            //  To execute a suspending function from a finally block,
            //  wrap the code within withContext(NonCancellable) function.
            withContext(NonCancellable) {
                delay(1000)
                println("Close resource in finally")
            }
        }
    }

    delay(10)  // let's print few value before coroutines get cancelled.
    job.cancel(CancellationException("My own crash message"))
    job.join()
    println("Main program ends: ${Thread.currentThread().name}")
}

