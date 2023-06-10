package com.musasoydas.bootcamp12mvvm.screen.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(private val currentScore: Int) : ViewModel() {

    private var _isPlayAgain = MutableLiveData<Boolean>()
    val isPlayAgain: LiveData<Boolean> get() = _isPlayAgain

    val score = currentScore
    fun playAgain() {
        _isPlayAgain.value = true

    }

    fun finishPlayAgainEvent() {
        _isPlayAgain.value=false

    }


}