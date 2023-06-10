package com.musasoydas.bootcamp12mvvm.screen.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.musasoydas.bootcamp12mvvm.R
import com.musasoydas.bootcamp12mvvm.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTitleBinding.inflate(inflater,container,false)
        return binding.root

       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnStart.setOnClickListener {
                val action=TitleFragmentDirections.actionTitleFragmentToGameFragment()
                findNavController().navigate(action)
            }
        }
    }


}