package com.alexadiamant.perfectcoloriesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.alexadiamant.perfectcoloriesapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    //binding current fragment
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    //initialize Args class
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //bind the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.lifecycleOwner = viewLifecycleOwner

        //set the click listener to go on main view
        binding.btHome.setOnClickListener {
            view.findNavController().navigate(R.id.action_resultFragment_to_collectInfoFragment)
        }

        //get args from other fragment
        val age = args.age.toInt()
        val weight = args.weight.toInt()
        val height = args.height.toInt()
        val gender = args.gender
        val activity = args.activity.toDouble()
        //use method to calculate and show data on view
        val normalCalories = count(age, weight, height, gender, activity)

        //set values to text views
        binding.tvResultNormal.text = "You need to get about $normalCalories to keep your shape"

        binding.tvGainWeight.text = "If you want to gain weight - keep getting about ${toGainWeight(normalCalories)}"

        binding.tvLoseWeight.text = "If you want to lose weight - keep getting about ${toLoseWeight(normalCalories)}"

        return view
    }

    //method to calculate calories using args as input data
    private fun count(age: Int, weight: Int, height: Int, gender: String, activity: Double): Int{
        val result = (447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age))
        //check gender of person for better quality of calculations
        when (gender){

            "Woman" -> {val result = (((9.99 * weight) + (6.25 * height) + (4.92 * age)) - 161) * activity}

            "Man" -> {val result = (((9.99 * weight) + (6.25 * height) + (4.92 * age)) + 5) * activity}
        }
        return result.toInt()
    }

    //method to calculate calories to gain weight
    private fun toGainWeight(normAmount: Int): Int{
        val toGain = normAmount + (normAmount * 0.3).toInt()
        return toGain
    }

    //method to calculate calories to lose weight
    private fun toLoseWeight(normAmount: Int): Int{
        val toLose = normAmount - (normAmount * 0.15).toInt()
        return toLose
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}