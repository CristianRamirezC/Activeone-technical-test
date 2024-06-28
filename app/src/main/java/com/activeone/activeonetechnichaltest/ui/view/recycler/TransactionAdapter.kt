package com.activeone.activeonetechnichaltest.ui.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.activeone.activeonetechnichaltest.R
import com.activeone.activeonetechnichaltest.data.model.TransactionModel

class TransactionAdapter(
    private val transactionsList: List<TransactionModel>
) : RecyclerView.Adapter<TransactionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TransactionViewHolder(
            layoutInflater.inflate(
                R.layout.item_transaction,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = transactionsList.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = transactionsList.elementAt(position)
        holder.render(item)
    }

}