package com.example.notesapp.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Model.Notes
import com.example.notesapp.R
import com.example.notesapp.databinding.ItemNotesBinding

class NotesAdapter(val requireContext: Context,val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    class notesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return  notesViewHolder(ItemNotesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubTitle.text = data.subTitle
        holder.binding.notesDate.text = data.date

        when(data.priority){
            "1" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
            "2" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.orange_dot)
            }
            "3" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
        }
    }

    override fun getItemCount() = notesList.size
}