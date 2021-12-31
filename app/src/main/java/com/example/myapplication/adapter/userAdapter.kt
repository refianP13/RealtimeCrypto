package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

import com.example.myapplication.modelData.gambar.Data


class userAdapter (private val list: ArrayList<Data>) : RecyclerView.Adapter<userAdapter.ListViewHolder>() {


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var atas: TextView = itemView.findViewById(R.id.atas)
        var bawah: TextView = itemView.findViewById(R.id.bawah)
        fun bind(list: Data){
            with(itemView){
                atas.text = "${list.email}"
                bawah.text = "${list.avatar}"

            }
        }

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.template_rv, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }


}