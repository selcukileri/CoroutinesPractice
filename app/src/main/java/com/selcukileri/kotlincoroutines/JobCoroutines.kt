package com.selcukileri.kotlincoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    //Job
    runBlocking {
        val myJob = launch {
            delay(2000)
            println("job")
            val secondJob = launch {
                println("job2")
            }
            secondJob.invokeOnCompletion {
                println("my 2nd job end")
            }
        }
        myJob.invokeOnCompletion {
            println("my job end")
        }
        myJob.cancel()

    }
}