package com.example.spacexdataapp.adapter

import Spacex_Base
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexdataapp.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.rocket_list.view.*

class RocketAdapter(private val spaceXBase: List<Spacex_Base>):RecyclerView.Adapter<RocketAdapter.ViewHolder>() {


    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val rocketName:TextView = view.rocket_name_id
        val rocketCountry:TextView = view.rocket_country_name_id
        val rocketEngineCount:TextView = view.rocket_engineCount_id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rocket_list,parent,false))
    }

    override fun getItemCount(): Int {
        return spaceXBase.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rocketName.text = spaceXBase[position].rocket_name
        holder.rocketCountry.text = spaceXBase[position].country
        holder.rocketEngineCount.text = spaceXBase[position].first_stage.engines.toInt().toString()
    }
}