package couroutinesScopeCoroutinesContextAndDispatchers

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

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
    // coroutineContext: Coroutines instance.

    /*
    Without parameter: CONFINED [CONFINED DISPATCHER].../
      - Inherit CoroutineContext from immediate parent coroutine.
      - Even after delay() or suspending function, it continues to run in the same thread.
      When to use Dispatchers.Main (a common confined dispatcher):
      - Ui updates
      - Maintaining State Consistency.
    */
    launch {
        println("C1: ${Thread.currentThread().name}")  // Thread: main
        delay(1000)
        println("C1 after delay: ${Thread.currentThread().name}")  // Thread: same main thread
    }

    /*
    With parameter: Dispatchers.Default [Similar to globalScope.launch{}] .../
        - gets its own context at global level, execute in a separates background thread.
        - After delay() or suspending function execution,
        it continues to run either in the same thread or in some other thread.
    */
    launch(Dispatchers.Default) {
        println("C2: ${Thread.currentThread().name}")  // Thread: T1
        delay(1000)
        println("C2 after delay: ${Thread.currentThread().name}")  // Thread: ?
    }

    /*
    With parameter: Dispatchers.Unconfined [UNCONFINED DISPATCHER] ...
        - Inherit CoroutineContext from the immediate parent coroutine.
        - After delay() or suspending function execution, it continues to run in some other thread.
     */
    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")
        delay(1000)
        println("C3 after delay: ${Thread.currentThread().name}")  // Thread: some other thread
    }

    // Using CoroutineContext property to flow context rom parent to child.
    launch(coroutineContext) {
        println("C4: ${Thread.currentThread().name}")  // Thread: main
        delay(1000)
        println("C4 after delay: ${Thread.currentThread().name}")  // Thread: main
    }

    println("... Main program ...")
}