package composingSuspendingFunctions

import kotlinx.coroutines.*


fun main(args: Array<String>) = runBlocking {  // create a blocking coroutine that execute in current thread.
    println("Main program starts: ${Thread.currentThread().name}")  // main thread.

    val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne() }
    val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwo() }
    println("The message is: ${msgOne.await() + msgTwo.await()}")

    println("Main program ends: ${Thread.currentThread().name}")  // main thread.
}

suspend fun getMessageOne(): String {
    delay(1000L)
    println("After working in getMessageOne()")
    return "Hello "
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    println("After working in getMessageTwo()")
    return "World!"
}
