package com.arabica.piratsgold.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arabica.piratsgold.R
import com.arabica.piratsgold.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {
    private lateinit var binding : FragmentSplashBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coroutineScope.launch {
            binding.progressBar.max = 1000
            val value = 1000
            ObjectAnimator.ofInt(binding.progressBar, "progress", value).setDuration(2000).start()
            delay(2000)
            goToTreeBlocks()
        }
    }
    private fun goToTreeBlocks(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.flMain, ThreeBlocksFragment())
            ?.commit()
    }
}