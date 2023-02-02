package com.playnoob.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.playnoob.R
import com.playnoob.databinding.FragmentMenuBinding
import com.playnoob.viewmodel.GameViewModel
import kotlin.system.exitProcess

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    val viewModel: GameViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        setName()
        setListeners()
        animateMenuButtons()
        // Inflate the layout for this fragment
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun setName() {
        val name = viewModel.getName()
        Log.d("TT", name)
        binding.tvUserName.text = "Welcome back, $name"
    }

    private fun animateMenuButtons() {
        binding.btnPlay.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_buttons))
        binding.btnShop.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_buttons))
        binding.btnRules.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_buttons))
        binding.btnExit.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_buttons))
    }

    private fun setListeners() {
        binding.btnPlay.setOnClickListener {
            if(viewModel.getModeEasy()){
                findNavController().navigate(R.id.action_menuFragment_to_easyGameFragment)
            }
            else{
                findNavController().navigate(R.id.action_menuFragment_to_normalgameFragment)
            }
        }
        binding.btnExit.setOnClickListener {
            exitProcess(0)
        }
        binding.btnRules.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_rulesFragment)
        }
        binding.btnShop.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_shopFragment)
        }
    }

}