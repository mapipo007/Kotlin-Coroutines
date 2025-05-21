package coroutinesIntroduction

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking{  // Execute in CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread.
    // execute CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread
    println("Main program starts: ${Thread.currentThread().name}")

    GlobalScope.launch { // Thread: T1.
        println("Fake work starts: ${Thread.currentThread().name}")  // Thread: T1.
        mySuspendFunc(1000)  // Coroutine is suspended but Thread: T1 is free (not blocked).
        println("Fake work finished: ${Thread.currentThread().name}")  // either T1 or other thread running.
    }
    mySuspendFunc(2000) // CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread: wait for coroutines to finish(practically not a right way to wait).
    // end CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread
    println("Main program ends: ${Thread.currentThread().name}")  // CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.CoroutinesIntroduction.main thread.
}

suspend fun mySuspendFunc(time: Long) {
    // code..
    delay(time)
}