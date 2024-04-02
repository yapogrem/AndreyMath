package com.example.andreymath

interface ArithmeticTask {
    fun getTask():Task
    fun check(input:Int,task:Task):Boolean
}

