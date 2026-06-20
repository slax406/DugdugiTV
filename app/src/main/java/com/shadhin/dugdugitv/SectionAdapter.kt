package com.shadhin.dugdugitv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SectionAdapter(
    private val sections: List<Section>,
    private val onClick: (Section) -> Unit
) : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    inner class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.cardTitle)
        val subtitle: TextView = view.findViewById(R.id.cardSubtitle)
        val root: View = view.findViewById(R.id.cardRoot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_section_card, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = sections[position]
        holder.title.text = section.title
        holder.subtitle.text = section.subtitle
        holder.root.setOnClickListener { onClick(section) }
    }

    override fun getItemCount(): Int = sections.size
}
