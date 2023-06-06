package com.example.guests.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.guests.databinding.RowGuestBinding
import com.example.guests.model.GuestModel
import com.example.guests.view.listener.onGuestListener
import com.example.guests.view.viewholder.GuestViewHolder
import kotlin.coroutines.coroutineContext

class GuestsAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var guestList:List<GuestModel> = listOf()
    private lateinit var listener:onGuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updateGuests(list :List<GuestModel>){
        guestList = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener: onGuestListener){
        listener = guestListener
    }
}