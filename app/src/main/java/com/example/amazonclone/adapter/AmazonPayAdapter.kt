package com.example.amazonclone.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.amazonclone.data.SearchItem
import com.example.amazonclone.databinding.AmazonpayMiniLayoutBinding
import com.example.amazonclone.databinding.AmazonpayMinilayoutSearchbasedBinding

class AmazonPayAdapter: RecyclerView.Adapter<ViewHolder>() {

    private var searchItems:List<SearchItem> = emptyList()

    private val VIEW_TYPE_DIFFERENT = 0
    private val VIEW_TYPE_REGULAR = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == VIEW_TYPE_DIFFERENT) {
            AmazonPayViewHolder(
                AmazonpayMiniLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        } else {
            AmazonPayListViewHolder(
                AmazonpayMinilayoutSearchbasedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {



            val amazonPayViewHolder = holder as AmazonPayViewHolder
            amazonPayViewHolder.bindAmazonPay()
        } else {

            val item = searchItems[position - 1]
            Log.d("AdapterDebug", "Binding item at position: $position, item name: ${item.name}")

            val amazonPayListViewHolder = holder as AmazonPayListViewHolder
            amazonPayListViewHolder.BindItem(item)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_DIFFERENT else VIEW_TYPE_REGULAR
    }

    class AmazonPayViewHolder(private val binding:AmazonpayMiniLayoutBinding):ViewHolder(binding.root){

        fun bindAmazonPay(){
            binding.let {
                it.txtviewamazonpay.text = "AmazonPay"
            }
        }
    }

    class AmazonPayListViewHolder(private val binding: AmazonpayMinilayoutSearchbasedBinding):ViewHolder(binding.root){

        fun BindItem(item: SearchItem){
            binding.txtviewsearchbase.text = item.name

            Glide.with(binding.imgviewsearchitem.context)
                .load(item.imagesrc)
                .into(binding.imgviewsearchitem)

        }

    }


    override fun getItemCount(): Int {
        return searchItems.size+1

    }

    fun setData(item:List<SearchItem>){
        this.searchItems = item
        Log.d("Searchsize", searchItems.size.toString())
        notifyDataSetChanged()
    }


}