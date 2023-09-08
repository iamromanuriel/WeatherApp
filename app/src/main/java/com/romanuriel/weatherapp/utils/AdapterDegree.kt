package com.romanuriel.weatherapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanuriel.weatherapp.R
import com.romanuriel.weatherapp.databinding.LayoutItemDegreesBinding

class AdapterDegree: RecyclerView.Adapter<AdapterDegree.DegreeViewHolder>() {
    private val listDegree = listOf<DegreesModel>()

    inner class DegreeViewHolder(private val b: LayoutItemDegreesBinding): RecyclerView.ViewHolder(b.root){
        fun build(degree: DegreesModel){
            b.itemDegreesOption.text = degree.type
            if(degree.select){
                b.checkReference.visibility = View.VISIBLE
                b.checkReference.setColorFilter(b.root.resources.getColor(android.R.color.holo_green_dark))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DegreeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_degrees, parent,false)
        return DegreeViewHolder(LayoutItemDegreesBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return listDegree.size
    }

    override fun onBindViewHolder(holder: DegreeViewHolder, position: Int) {
        val degree = listDegree[position]
        holder.build(degree)
    }
}