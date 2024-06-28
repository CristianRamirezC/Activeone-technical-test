package com.activeone.activeonetechnichaltest.ui.view.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.databinding.ItemTransactionBinding

class TransactionViewHolder(val view: View): ViewHolder(view) {

    private val binding = ItemTransactionBinding.bind(view)

    private val transactionConcept = binding.transactionConceptTV
    private val transactionValue = binding.transactionValueTV
    fun render(transaction: TransactionModel) {

        transactionConcept.text = transaction.transactionConcept
        transactionValue.text = transaction.transactionValue.toString()
    }

}