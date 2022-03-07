package com.example.edvora.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.edvora.R
import com.example.edvora.api.Rides
import com.example.edvora.api.RidesItem
import com.example.edvora.databinding.ItemLayoutBinding

class RidesAdapter(private val items : Rides) :
    RecyclerView.Adapter<RidesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RidesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return RidesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RidesViewHolder, position: Int) {
        holder.cityName.text = items[position].city
        holder.stateName.text = items[position].state
        holder.id.text = items[position].id.toString()
        holder.originStation.text = items[position].origin_station_code.toString()
        holder.date.text = items[position].date
        holder.stationPath.text = items[position].station_path.toString()
    }

    override fun getItemCount() = items.size

}