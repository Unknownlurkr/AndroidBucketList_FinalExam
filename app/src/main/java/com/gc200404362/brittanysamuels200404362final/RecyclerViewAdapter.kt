package com.gc200404362.brittanysamuels200404362final

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val context : Context, val entries : List<Entry>): RecyclerView.Adapter<RecyclerViewAdapter.EntryViewHolder>(){

    inner class EntryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)
        val ratingTextView = itemView.findViewById<TextView>(R.id.ratingTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
            val entry = entries[position]
            holder.nameTextView.text = entry.destination
            holder.descriptionTextView.text = entry.description
            holder.ratingTextView.text = entry.rank!!.toInt().toString()

    }

    override fun getItemCount(): Int {
        return entries.size
    }
}