package com.example.assignmentneo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentneo.databinding.ItemViewpagerBannerBinding
import com.example.assignmentneo.model.HorizontalAndVerticalListModel

class HorizontalListAdapter(
    private val horizontalAndVerticalListModelList: List<HorizontalAndVerticalListModel>,
    private val onHorizontalListItemClick: (horizontalAndVerticalListModel: HorizontalAndVerticalListModel) -> Unit
) : RecyclerView.Adapter<HorizontalListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemViewpagerBannerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewpagerBannerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.ivBanner.setImageResource(horizontalAndVerticalListModelList[position].bannerUrl)
            binding.root.setOnClickListener {
                onHorizontalListItemClick(horizontalAndVerticalListModelList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return horizontalAndVerticalListModelList.size
    }
}