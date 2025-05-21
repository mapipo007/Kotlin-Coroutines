package couroutinesScopeCoroutinesContextAndDispatchers

import kotlinx.coroutines.*

/*
fun main(args: Array<String>) = runBlocking {
    println("RunBlocking: $this")

    launch {
        println("Launch: $this")
    }

    async {
        println("Async: $this")
    }

    println("... some other code ...")
}
*/

fun main(args: Array<String>) = runBlocking { // Thread: main
    // this: Coroutines instance.
    // coroutineContext; Coroutines instance.

    // Without parameter: CONFINED [CONFINED DISPATCHER].../
    launch {
        println("C1: ${Thread.currentThread().name}")  // Thread: main
    }

    // With parameter: Dispatchers.Default [Similar to globalScope.launch{}] .../
    launch(Dispatchers.Default) {
        println("C2: ${Thread.currentThread().name}")  // Thread: T1
        delay(1000)
        println("C2 after delay: ${Thread.currentThread().name}")  // Thread: ?
    }

    // With parameter: Dispatchers.Unconfined [UNCONFINED DISPATCHER] .../
    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")
    }

    println("... Main program ...")
}