package com.example.edvora.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edvora.R

class RidesViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val id = view.findViewById<TextView>(R.id.rideId)
    val cityName = view.findViewById<TextView>(R.id.cityName)
    val stateName = view.findViewById<TextView>(R.id.stateName)
    val originStation = view.findViewById<TextView>(R.id.StationVal)
    val stationPath = view.findViewById<TextView>(R.id.station_pathVal)
    val date = view.findViewById<TextView>(R.id.dateVal)

}