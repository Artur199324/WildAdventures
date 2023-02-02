package com.playnoob.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.playnoob.databinding.FragmentNormalgameBinding
import com.playnoob.viewmodel.GameViewModel

class NormalgameFragment : Fragment() {
    private var _binding: FragmentNormalgameBinding? = null
    private val binding get() = _binding!!
    var gameIsLive = false
    val viewModel: GameViewModel by activityViewModels()
    private var mToast: Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNormalgameBinding.inflate(inflater, container, false)
        setListeners()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setListeners() {
        binding.ibArrowBack.setOnClickListener {
            findNavController().navigate(
                NormalgameFragmentDirections.actionNormalgameFragmentToMenuFragment())        }
        binding.btnUseAttempt.setOnClickListener {
            if (viewModel.getAttempts() > 0) {
                viewModel.minusOneGame()
                binding.btnAccept.isEnabled = false
                if (!gameIsLive) {
                    gameIsLive = true
                    mToast?.cancel()
                    mToast = Toast.makeText(context, "Game started!", Toast.LENGTH_SHORT)
                    mToast?.show()
                    Log.d("TAGG", gameIsLive.toString())
                    gameLogic()
                } else {
                    mToast?.cancel()
                    mToast = Toast.makeText(context, "Game is already started!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
            } else {
                mToast?.cancel()
                mToast = Toast.makeText(context, "Please,buy new attempts!", Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
    }

    private fun gameLogic() {
        if (gameIsLive) {
            binding.btnAccept.isEnabled = true
            binding.ibArrowBack.isEnabled = false
            binding.ivStrangeFirst.isEnabled = true
            binding.ivStrangeSecond.isEnabled = true
            binding.ivStrangeThird.isEnabled = true
            binding.ivStrangeFourth.isEnabled = true
            binding.ivStrangeFifth.isEnabled = true
            val gameArray: BooleanArray = booleanArrayOf(true, true, true, true, true)
            val chooseArray: BooleanArray = booleanArrayOf(false, false, false, false, false)
            val wrongArray: IntArray = intArrayOf(0, 1, 2, 3, 4)
            val listWrong = wrongArray.asSequence().shuffled().take(2).toList()
            gameArray[listWrong[0]] = false
            gameArray[listWrong[1]] = false
            Log.d("TAGG", listWrong.toString())
            binding.ivStrangeFirst.setOnClickListener {
                Log.d("TAGG", "1 clicked")
                if (!chooseArray[0]) {
                    chooseArray[0] = true
                    binding.ivStrangeFirst.setColorFilter(Color.CYAN)
                } else {
                    chooseArray[0] = false
                    binding.ivStrangeFirst.clearColorFilter()
                }
            }
            binding.ivStrangeSecond.setOnClickListener {
                Log.d("TAGG", "1 clicked")
                if (!chooseArray[1]) {
                    chooseArray[1] = true
                    binding.ivStrangeSecond.setColorFilter(Color.CYAN)
                } else {
                    chooseArray[1] = false
                    binding.ivStrangeSecond.clearColorFilter()
                }
            }
            binding.ivStrangeThird.setOnClickListener {
                Log.d("TAGG", "1 clicked")
                if (!chooseArray[2]) {
                    chooseArray[2] = true
                    binding.ivStrangeThird.setColorFilter(Color.CYAN)
                } else {
                    chooseArray[2] = false
                    binding.ivStrangeThird.clearColorFilter()
                }
            }
            binding.ivStrangeFourth.setOnClickListener {
                Log.d("TAGG", "1 clicked")
                if (!chooseArray[3]) {
                    chooseArray[3] = true
                    binding.ivStrangeFourth.setColorFilter(Color.CYAN)
                } else {
                    chooseArray[3] = false
                    binding.ivStrangeFourth.clearColorFilter()
                }
            }
            binding.ivStrangeFifth.setOnClickListener {
                Log.d("TAGG", "1 clicked")
                if (!chooseArray[4]) {
                    chooseArray[4] = true
                    binding.ivStrangeFifth.setColorFilter(Color.CYAN)
                } else {
                    chooseArray[4] = false
                    binding.ivStrangeFifth.clearColorFilter()
                }
            }
            binding.btnAccept.setOnClickListener {
                binding.ivStrangeFirst.isEnabled = false
                binding.ivStrangeSecond.isEnabled = false
                binding.ivStrangeThird.isEnabled = false
                binding.ivStrangeFourth.isEnabled = false
                binding.ivStrangeFifth.isEnabled = false
                binding.ibArrowBack.isEnabled = true
                binding.btnAccept.isEnabled = false
                gameIsLive = false
                Log.d("TAGG", "pressed")
                if (gameArray.contentEquals(chooseArray)) {
                    mToast?.cancel()
                    mToast = Toast.makeText(context, "You win!", Toast.LENGTH_SHORT)
                    mToast?.show()
                } else {
                    mToast?.cancel()
                    mToast = Toast.makeText(context, "You lose!", Toast.LENGTH_SHORT)
                    mToast?.show()
                }
                binding.ivStrangeFirst.clearColorFilter()
                binding.ivStrangeSecond.clearColorFilter()
                binding.ivStrangeThird.clearColorFilter()
                binding.ivStrangeFourth.clearColorFilter()
                binding.ivStrangeFifth.clearColorFilter()
            }
        }
    }
}