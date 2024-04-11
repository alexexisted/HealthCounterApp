package com.alexadiamant.perfectcoloriesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.alexadiamant.perfectcoloriesapp.databinding.FragmentCollectInfoBinding

class CollectInfoFragment : Fragment() {
    private var _binding: FragmentCollectInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment and bind it to the view
        _binding = FragmentCollectInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.lifecycleOwner = viewLifecycleOwner

        //set listener on calculate button
        binding.btCalculate.setOnClickListener {

            //add values to get them from this fragment
            val ageEt = binding.etAge.text.toString()
            val weightEt = binding.etWeight.text.toString()
            val heightEt = binding.etHeight.text.toString()
            val radioGroup = binding.rgGender.checkedRadioButtonId
            var gender = ""
            val userActivity = binding.spActivity.selectedItem.toString()
            var activityLevel: Float = 0.0F

            //check which radio button was pressed and set value to gender
            if (radioGroup.equals(binding.rbMan)) {
                gender = "Man"
            }
            else {gender = "Woman"}

            //check which activity user choose and set coefficient to level variable
            when (userActivity) {
                "I am not doing sport" -> {activityLevel = 1.2F}
                "1 – 3 training a week" -> {activityLevel = 1.375F}
                "3 – 5 training a week" -> {activityLevel = 1.55F}
                "More than your can imagine" -> {activityLevel = 1.8F}
            }

            //navigate to next fragment and bring args with
            val action = CollectInfoFragmentDirections.actionCollectInfoFragmentToResultFragment(ageEt, weightEt, heightEt, gender, activityLevel)

            //use nav controller to navigate
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}