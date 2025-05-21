package coroutinesIntroduction

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.*

/*
// coroutines builders are specifically: launch, runBlocking and async.
@OptIn(DelicateCoroutinesApi::class)
fun CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main(args: Array<String>) {
    // create coroutines at global level.
    GlobalScope.launch {
        // File download.
        // Play music.
    }

    // create coroutines at local level.
    launch {
        // some data computation.
        // Login operation.
    }
}
*/

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking{  // Execute in CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread.
    // execute CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread
    println("Main program starts: ${Thread.currentThread().name}")  // CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main Thread.

    val job: Job = launch {  // CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main Thread.
        println("Fake work starts: ${Thread.currentThread().name}")  // CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main Thread.
        delay(1000)  // Coroutine is suspended but Thread: T1 is free (not blocked).
        println("Fake work finished: ${Thread.currentThread().name}")  // either T1 or other thread running.
    }
    // mSuspendFunc(2000)  CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread: wait for coroutines to finish(practically not a right way to wait).
    job.join()  // note that to cancel the coroutine, we call job.cancel().
    // end CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread
    println("Main program ends: ${Thread.currentThread().name}")  // CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread.
}
