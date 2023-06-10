package com.musasoydas.bootcamp12mvvm.screen.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _word = MutableLiveData<String>()
    val word: LiveData<String> get() = _word

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    private var _endGame = MutableLiveData<Boolean>()
    val endGame: LiveData<Boolean> get() = _endGame


    private lateinit var wordList: MutableList<String>

    init {
        _score.value = 0
        resetList()
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketboll",
            "cat",
            "dog",
            "snail",
            "doctor",
            "home",
            "breakfest",
            "good afternoon",
            "good morning",
            "yes",
            "no",
            "car",
            "bus",
            "rool",
            "yellow",
            "green"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty ()) {
            _word.value = wordList.removeAt(0)
        } else {
            onEndGame()
        }
    }

    fun onSKip() {
        _score.value = _score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = _score.value?.plus(1)
        nextWord()
    }

    fun onEndGame() {
        _endGame.value = true
    }

    fun finisGameFnishEvent() {
        _endGame.value = false
    }
}