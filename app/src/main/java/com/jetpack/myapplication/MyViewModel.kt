package com.jetpack.myapplication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val state = mutableStateOf(MyScreenState())

    fun updateText(newText: String) {
        state.value = state.value.copy(textState = newText)
    }

    fun updateNameList(){
        val currentList = state.value.namesList
        currentList.add(state.value.textState)
        state.value = state.value.copy(namesList = currentList)
    }

}