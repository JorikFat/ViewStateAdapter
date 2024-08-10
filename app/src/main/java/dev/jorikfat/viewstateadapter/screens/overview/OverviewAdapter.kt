package dev.jorikfat.viewstateadapter.screens.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jorikfat.viewstateadapter.Field
import dev.jorikfat.viewstateadapter.databinding.ItemOverviewBinding

class OverviewAdapter(
    private val items :List<Field>
) :RecyclerView.Adapter<OverviewAdapter.OverviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder =
        OverviewViewHolder(ItemOverviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    class OverviewViewHolder(private val layout :ItemOverviewBinding) :RecyclerView.ViewHolder(
        layout.root
    ) {
        fun bind(field :Field){
            layout.title.text = field.title
            layout.value.text = field.value
        }
    }
}