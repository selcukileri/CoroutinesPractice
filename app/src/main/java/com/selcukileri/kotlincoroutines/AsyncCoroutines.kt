package com.selcukileri.kotlincoroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    var userName = ""
    var userAge = 0

    runBlocking {
    val downloadedName = async {
        downdloadName()
    }
    val downloadedAge = async {
        downloadAge()
    }
    userName = downloadedName.await()
    userAge = downloadedAge.await()
    println("${userName} ${userAge}")


    }
}

suspend fun downdloadName() : String {
    delay(2000)
    val username = "Selcuk: "
    println("username download")
    return username
}

suspend fun downloadAge(): Int {
    delay(4000)
    val userAge = 25
    println("userage download")
    return userAge
}