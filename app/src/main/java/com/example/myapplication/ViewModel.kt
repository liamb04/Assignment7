package com.example.myapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    val height: MutableState<String> = mutableStateOf("")
    val weight: MutableState<String> = mutableStateOf("")
    val bmiResult: MutableState<Float> = mutableStateOf(0f)

    fun updateWeight(newWeight: String) {
        weight.value = newWeight
    }

    fun updateHeight(newHeight: String) {
        height.value = newHeight
    }
    fun updateText(){
       bmiResult.value= calculate(weight.value.toDouble(),height.value.toDouble()).toFloat()
    }

    fun calculate(weight: Double, height: Double): Double{

        val cmHeight=height/100
        return weight / (cmHeight * cmHeight)
    }
}
