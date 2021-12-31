package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.modelData.crypto.aaData
import com.example.myapplication.modelData.gambar.passingBuy


import com.example.myapplication.modelData.gambar.srcGambarItem
import com.squareup.picasso.Picasso


class bitcoinAdapter (private val list: ArrayList<srcGambarItem>, private val tik: ArrayList<passingBuy>) : RecyclerView.Adapter<bitcoinAdapter.ListViewHolder>() {


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pict: ImageView = itemView.findViewById(R.id.img_item_photo)
        var text: TextView = itemView.findViewById(R.id.atas)
        var bawah: TextView = itemView.findViewById(R.id.bawah)
        var k = 0



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.template_rv, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: bitcoinAdapter.ListViewHolder, position: Int) {
        val listkan = list[position]
        val tikkan = tik[position]
        Picasso.get()
            .load(listkan.url_logo_png)
            .into(holder.pict);
        holder.text.text = listkan.description
        holder.bawah.text = tikkan.harga

    }

    override fun getItemCount(): Int {
        return list.size

    }


}

