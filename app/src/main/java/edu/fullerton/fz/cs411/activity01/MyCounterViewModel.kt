package edu.fullerton.fz.cs411.activity01

import androidx.lifecycle.ViewModel

class MyCounterViewModel: ViewModel() {

    private var counter: Int = 0

    fun getCounter(): Int {
        return this.counter
    }

    fun setCounter(newCount: Int) {
        counter = newCount
    }

    fun increaseCounter() {
        counter += 1
    }

}