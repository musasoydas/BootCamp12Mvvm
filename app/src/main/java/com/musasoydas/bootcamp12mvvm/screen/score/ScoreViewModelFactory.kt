package com.musasoydas.bootcamp12mvvm.screen.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreViewModelFactory(private val score: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(score) as T
        }
        else{
            throw IllegalStateException("can not creat instance of this viewModel")
        }

    }
}