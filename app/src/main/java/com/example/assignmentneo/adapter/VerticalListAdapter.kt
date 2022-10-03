package com.example.assignmentneo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentneo.databinding.ItemVerticalListBinding
import com.example.assignmentneo.model.VerticalListModel

class VerticalListAdapter(
    private val verticalListModel: List<VerticalListModel>,
    private val onVerticalListItemClick: (verticalListModel: VerticalListModel) -> Unit
) : RecyclerView.Adapter<VerticalListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemVerticalListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerticalListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.ivIcon.setImageResource(verticalListModel[position].iconUrl)
            binding.tvTitle.text = verticalListModel[position].title
            binding.root.setOnClickListener {
                onVerticalListItemClick(verticalListModel[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return verticalListModel.size
    }

}