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

    private val contract = ContractsImpl()

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

            //bind values to get them from this fragment
            val ageEt = binding.etAge.text.toString()
            val weightEt = binding.etWeight.text.toString()
            val heightEt = binding.etHeight.text.toString()
            val radioButtonMan = binding.rbMan.isChecked
            val userActivity = binding.spActivity.selectedItem.toString()

            //use interface's implementation to logic
            val activityLevel = contract.getLevelOfActivity(userActivity)
            val gender = contract.getGender(radioButtonMan)

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