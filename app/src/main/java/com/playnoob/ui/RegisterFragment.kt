package com.playnoob.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.playnoob.R
import com.playnoob.databinding.FragmentRegisterBinding
import com.playnoob.viewmodel.GameViewModel

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setListeners()
        setAnimation()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setAnimation() {
        binding.ivCenter.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate))
    }

    private fun setListeners() {
        binding.btnSubmit.setOnClickListener {
            if(binding.editTextTextPersonName.text.isNotEmpty() && !binding.editTextTextPersonName.text.contains(' ')){
                viewModel.setName(binding.editTextTextPersonName.text.toString())
                findNavController().navigate(
                    RegisterFragmentDirections.actionRegisterFragmentToMenuFragment())}
            else{
                Toast.makeText(context, "Enter your user name without spaces,please", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}