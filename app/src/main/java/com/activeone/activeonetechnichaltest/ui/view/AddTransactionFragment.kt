package com.activeone.activeonetechnichaltest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.activeone.activeonetechnichaltest.R
import com.activeone.activeonetechnichaltest.databinding.FragmentAddTransactionBinding
import com.activeone.activeonetechnichaltest.databinding.FragmentLoginBinding

class AddTransactionFragment : Fragment() {

    private lateinit var binding: FragmentAddTransactionBinding

    //Views
    private lateinit var transactionConceptET: EditText
    private lateinit var transactionValueET: EditText
    private lateinit var saveTransactionBTN: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewBinding()
        setPopBackStack()
    }

    private fun setUpViewBinding() {
        transactionConceptET = binding.transactionConceptET
        transactionValueET = binding.transactionValueET
        saveTransactionBTN = binding.saveTransactionBTN
    }

    private fun setPopBackStack() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
    }

}