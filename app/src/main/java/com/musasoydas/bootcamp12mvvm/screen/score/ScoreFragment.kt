package com.musasoydas.bootcamp12mvvm.screen.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.musasoydas.bootcamp12mvvm.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
private lateinit var binding : FragmentScoreBinding
private lateinit var scoreViewModel: ScoreViewModel
    private val args: ScoreFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentScoreBinding.inflate(inflater,container,false)


        val scoreViewModelFactory=ScoreViewModelFactory(args.score)
        scoreViewModel= ViewModelProvider(this,scoreViewModelFactory)[ScoreViewModel::class.java]

        scoreViewModel.isPlayAgain.observe(viewLifecycleOwner) { playAgain ->
            if (playAgain) {
                goToGameScreen()
            }

        }

        binding.textView.text=scoreViewModel.score.toString()

        binding.btnPlayAgain.setOnClickListener {
            onPlayAgain()
        }

        return binding.root
    }

    private fun goToGameScreen() {
       val action=ScoreFragmentDirections.actionScoreFragmentToGameFragment()
        findNavController().navigate(action)
        scoreViewModel.finishPlayAgainEvent()
    }

    private fun onPlayAgain() {
        scoreViewModel.playAgain()

    }


}