package com.example.guests.view.viewholder

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.guests.databinding.RowGuestBinding
import com.example.guests.model.GuestModel
import com.example.guests.view.listener.onGuestListener

class GuestViewHolder(private val binding: RowGuestBinding, private val listener: onGuestListener) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(guest: GuestModel) {
        binding.textName.text = guest.name

        binding.imgEdit.setOnClickListener {
            listener.onEdit(guest.id)
        }
        binding.imgDelete.setOnClickListener{
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNegativeButton("Não", null)
                .create()
                .show()

        }
    }
}