package es.wokis.catalogtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.wokis.catalogtest.databinding.PocRowBinding

class Adapter : ListAdapter<PocVO, Adapter.Holder>(DiffUtils()) {

    class Holder(private val binding: PocRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pocVO: PocVO) {
            binding.rowText.text = pocVO.message
        }
    }

    class DiffUtils : DiffUtil.ItemCallback<PocVO>() {
        override fun areItemsTheSame(oldItem: PocVO, newItem: PocVO): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PocVO, newItem: PocVO): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PocRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}