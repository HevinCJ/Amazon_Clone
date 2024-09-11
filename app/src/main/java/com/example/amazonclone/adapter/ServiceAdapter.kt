package com.example.amazonclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.amazonclone.data.ItemModel
import com.example.amazonclone.databinding.ServicesRcviewLayoutBinding

class ServiceAdapter:RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

     private var serviceitemlist:List<ItemModel> = emptyList()

    class ServiceViewHolder(private val binding:ServicesRcviewLayoutBinding):ViewHolder(binding.root){

        fun bindServices(itemModel: ItemModel){
            binding.txtviewitem.text = itemModel.title
            binding.imgviewitem.setImageResource(itemModel.imageRes)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(ServicesRcviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return serviceitemlist.size
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val currentitem = serviceitemlist[position]
        holder.bindServices(currentitem)
    }


    fun setData(itemModel:List< ItemModel>){
        this.serviceitemlist = itemModel
        notifyDataSetChanged()
    }

 }


