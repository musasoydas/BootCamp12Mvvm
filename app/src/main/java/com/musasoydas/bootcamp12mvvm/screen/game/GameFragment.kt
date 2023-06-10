package com.musasoydas.bootcamp12mvvm.screen.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.musasoydas.bootcamp12mvvm.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]


        gameViewModel.word.observe(viewLifecycleOwner, { gelenveri ->
            binding.wordText.text = gelenveri
        })

        gameViewModel.score.observe(viewLifecycleOwner, {
            binding.scoreText.text = it.toString()
        })
        gameViewModel.endGame.observe(viewLifecycleOwner,{
           if(it){
               gameViewModel.finisGameFnishEvent()
               val action =
                   GameFragmentDirections.actionGameFragmentToScoreFragment(gameViewModel.score.value ?: 0)
               findNavController().navigate(action)
           }
        })

        binding.endGameButton.setOnClickListener { onEndGame() }
        binding.gotIt.setOnClickListener { onCorrect() }
        binding.skip.setOnClickListener { onSkip() }
        return binding.root
    }

    private fun onEndGame() {

        gameViewModel.onEndGame()

    }


    private fun onCorrect() = gameViewModel.onCorrect()

    private fun onSkip() = gameViewModel.onSKip()


}