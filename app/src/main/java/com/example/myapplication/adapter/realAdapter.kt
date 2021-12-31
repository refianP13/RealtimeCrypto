package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.modelData.gambar.Data

class realAdapter (private val list: ArrayList<Data>): RecyclerView.Adapter<realAdapter.listViewHolder>(){
    inner class listViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var atas: TextView = itemView.findViewById(R.id.atas)
        var bawah: TextView = itemView.findViewById(R.id.bawah)
        fun bind(list: Data){
            with(itemView){
                atas.text = "${list.email}"
                bawah.text = "${list.avatar}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): realAdapter.listViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.template_rv, parent, false)
        return listViewHolder(view)
    }

    override fun onBindViewHolder(holder: realAdapter.listViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}