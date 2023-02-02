package com.playnoob.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.playnoob.R
import com.playnoob.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        animateViews()

        startWA.st { go->
            if (go){
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToRegisterFragment())
            }else{
                findNavController().navigate(
                    R.id.WAWActivity)
            }
        }

        return binding.root
    }

    private fun animateViews() {
        binding.imageView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate))
    }

}