package com.example.amazonclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.amazonclone.databinding.ImagesliderViewpagerLayoutBinding

class ImageSliderAdapter:RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder>() {

       private var imageList:List<Int> = emptyList()

      class ImageSliderViewHolder(private val binding: ImagesliderViewpagerLayoutBinding):ViewHolder(binding.root) {

          fun bindItem(item: Int) {
              Glide.with(binding.imgviewimages.context)
                  .load(item)
                  .into(binding.imgviewimages)

          }

      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderViewHolder {
        return ImageSliderViewHolder(ImagesliderViewpagerLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageSliderViewHolder, position: Int) {
       val currentitem= imageList[position]
        holder.bindItem(currentitem)
    }


    fun setImage(item: List<Int>){
        this.imageList = item
        notifyDataSetChanged()
    }
}