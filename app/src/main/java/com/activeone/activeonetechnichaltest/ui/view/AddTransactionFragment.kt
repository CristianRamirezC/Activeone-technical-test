package com.activeone.activeonetechnichaltest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.activeone.activeonetechnichaltest.R
import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.databinding.FragmentAddTransactionBinding
import com.activeone.activeonetechnichaltest.databinding.FragmentLoginBinding
import com.activeone.activeonetechnichaltest.ui.viewModel.AddTransactionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTransactionFragment : Fragment() {

    private lateinit var binding: FragmentAddTransactionBinding

    //ViewModel
    private val addTransactionsViewModel: AddTransactionViewModel by viewModels()

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
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {

        val toTransactionsFragmentDirection: NavDirections =
            AddTransactionFragmentDirections.actionAddTransactionFragmentToTransactionsFragment()
        saveTransactionBTN.setOnClickListener {
            addTransactionsViewModel.saveTransaction(
                TransactionModel(
                    transactionConcept = transactionConceptET.text.toString(),
                    transactionValue = transactionValueET.text.toString().toDouble()
                )
            )
            navigateToFragment(toTransactionsFragmentDirection)
        }
    }

    private fun navigateToFragment(direction: NavDirections) {
        val navController = findNavController()
        navController.navigate(direction)
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