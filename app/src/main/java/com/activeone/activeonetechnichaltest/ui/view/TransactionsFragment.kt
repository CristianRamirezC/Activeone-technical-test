package com.activeone.activeonetechnichaltest.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.databinding.FragmentTransactionsBinding
import com.activeone.activeonetechnichaltest.ui.view.recycler.TransactionAdapter
import com.activeone.activeonetechnichaltest.ui.viewModel.TransactionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionsFragment : Fragment() {

    private lateinit var binding: FragmentTransactionsBinding
    private val transactionsViewModel: TransactionsViewModel by viewModels()

    //Views
    private lateinit var currentBalanceTV: TextView
    private lateinit var addTransactionBTN: Button
    private lateinit var calculateBalanceBTN: Button
    private lateinit var recyclerTransactionsRV: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transactionsViewModel.getAllTransactions()
        setUpViewBinding()
        setUpOnClickListeners()
        initRecyclerView()
        setUpLiveDataObservers()

    }

    @SuppressLint("SetTextI18n")
    private fun setUpLiveDataObservers() {
        transactionsViewModel.allTransactions.observe(viewLifecycleOwner) { transactions ->
            recyclerTransactionsRV.adapter = TransactionAdapter(transactions)
        }

        transactionsViewModel.balance.observe(viewLifecycleOwner) {balance ->
            currentBalanceTV.text = "$${balance}"
        }

    }
    private fun initRecyclerView() {
        recyclerTransactionsRV.layoutManager = LinearLayoutManager(activity?.applicationContext)
        recyclerTransactionsRV.adapter = TransactionAdapter(listOf())
    }

    private fun setUpOnClickListeners() {
        val toAddTransactionFragmentDirection: NavDirections =
            TransactionsFragmentDirections.actionTransactionsFragmentToAddTransactionFragment()
        addTransactionBTN.setOnClickListener {
            navigateToFragment(toAddTransactionFragmentDirection)
        }

        calculateBalanceBTN.setOnClickListener {
            transactionsViewModel.calculateBalance()
        }

    }

    private fun setUpViewBinding() {
        currentBalanceTV = binding.currentBalanceTV
        addTransactionBTN = binding.addTransactionBTN
        calculateBalanceBTN = binding.calculateBalanceBTN
        recyclerTransactionsRV = binding.recyclerTransactionRV
    }

    private fun navigateToFragment(direction: NavDirections) {
        val navController = findNavController()
        navController.navigate(direction)
    }

}