package com.example.amazonclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.amazonclone.data.SpecialDeals
import com.example.amazonclone.databinding.SpecialDealsLayoutBinding

class SpecialDealsAdapter:RecyclerView.Adapter<SpecialDealsAdapter.SpecialDealsViewHolder>() {

    private var specialItems:List<SpecialDeals> = emptyList()


    class SpecialDealsViewHolder(private val binding: SpecialDealsLayoutBinding):ViewHolder(binding.root){

        fun bindSpecialDeals(item:SpecialDeals){
            binding.apply {
                imgviewfirst.setImageResource(item.firstImage)
                txtviewofferamount1.text = item.firstItem
                imgviewsecond.setImageResource(item.secondImage)
                txtviewofferamount2.text = item.secondItem
                imgviewthird.setImageResource(item.thirdImage)
                txtviewofferamount3.text=item.thirdItem
                imgviewfourth.setImageResource(item.fourthImage)
                txtviewofferamount4.text = item.fourthItem

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialDealsViewHolder {
        return SpecialDealsViewHolder(SpecialDealsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return specialItems.size
    }

    override fun onBindViewHolder(holder: SpecialDealsViewHolder, position: Int) {
        val currentdeal = specialItems[position]

        holder.bindSpecialDeals(currentdeal)
    }


    fun setDeals(item: List<SpecialDeals>){
        this.specialItems = item
        notifyDataSetChanged()
    }

}