package com.jetpack.myapplication

data class MyScreenState(
    val textState: String = "",
    val namesList: MutableList<String> = mutableListOf(),
)
