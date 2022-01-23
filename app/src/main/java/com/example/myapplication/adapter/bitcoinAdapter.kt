package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.modelData.crypto.aaData
import com.example.myapplication.modelData.gambar.passingBuy


import com.example.myapplication.modelData.gambar.srcGambarItem
import com.squareup.picasso.Picasso


class bitcoinAdapter (  private val list: ArrayList<srcGambarItem>,
                        private val tik: ArrayList<passingBuy>,
                        ) : RecyclerView.Adapter<bitcoinAdapter.ListViewHolder>() {

    interface onItemClickListener{
        fun  onItemclick(position: Int)
    }
    private lateinit var mlistener : onItemClickListener
    fun setOnclickListener(listener: onItemClickListener){
        mlistener = listener
    }

    inner class ListViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var pict: ImageView = itemView.findViewById(R.id.img_item_photo)
        var text: TextView = itemView.findViewById(R.id.atas)
        var bawah: TextView = itemView.findViewById(R.id.bawah)
        var buy: TextView = itemView.findViewById(R.id.buy)
        var sell: TextView = itemView.findViewById(R.id.sell)
        init {
            itemView.setOnClickListener{
                listener.onItemclick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.template_rv, parent, false)
        return ListViewHolder(view,mlistener)
    }
    override fun onBindViewHolder(holder: bitcoinAdapter.ListViewHolder, position: Int) {
        val listkan = list[position]
        val tikkan = tik[position]
        Picasso.get()
            .load(listkan.url_logo_png)
            .into(holder.pict);
        holder.text.text = listkan.description
        holder.bawah.text = tikkan.volume
        holder.buy.text = "Rp. ${tikkan.harga}"
        holder.sell.text = "Rp. ${tikkan.jual}"

    }

    override fun getItemCount(): Int {
        return list.size

    }


}

