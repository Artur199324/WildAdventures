package com.playnoob.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.playnoob.databinding.FragmentShopBinding
import com.playnoob.viewmodel.GameViewModel


class ShopFragment : Fragment() {
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    val viewModel: GameViewModel by activityViewModels()
    private var mToast: Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        setViews()

        setListeners()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun setListeners() {
        binding.ibArrowBack.setOnClickListener {
            findNavController().navigate(
                ShopFragmentDirections.actionShopFragmentToMenuFragment())
        }
        binding.btnBuy.setOnClickListener {
            viewModel.buyOneGame()
            val attempts = viewModel.getAttempts()
            binding.tvAttempts.text = "You have $attempts attempts "
        }
        binding.switchEasyMode.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {

                viewModel.setEasyMode(true)
                mToast?.cancel()
                mToast= Toast.makeText(context, "Easy mode ON", Toast.LENGTH_SHORT)
                mToast?.show()
            } else {
                viewModel.setEasyMode(false)
                mToast?.cancel()
                mToast= Toast.makeText(context, "Easy mode OFF", Toast.LENGTH_SHORT)
                mToast?.show()
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private fun setViews() {
        val attempts = viewModel.getAttempts()
        binding.tvAttempts.text = "You have $attempts attempts "
        binding.switchEasyMode.isChecked = viewModel.getModeEasy()
    }
}