package com.example.andreymath

enum class Operations{
    MINUS,
    PLUS;
    companion object{
        fun getOperation(index:Int):Operations{
            return when(index){
                1-> PLUS
                else -> MINUS
            }
        }
    }
}