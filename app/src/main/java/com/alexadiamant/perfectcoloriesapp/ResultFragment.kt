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

    private val contract = ContractsImpl()

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

        //use methods to calculate and show data on view
        val normalCalories = contract.count(age, weight, height, gender, activity)

        val toGain = contract.toGainWeight(normalCalories)

        val toLose = contract.toLoseWeight(normalCalories)

        //set values to text views
        binding.tvResultNormal.text = "You need to get about $normalCalories to keep your shape"

        binding.tvGainWeight.text = "If you want to gain weight - keep getting about $toGain"

        binding.tvLoseWeight.text = "If you want to lose weight - keep getting about $toLose"

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}