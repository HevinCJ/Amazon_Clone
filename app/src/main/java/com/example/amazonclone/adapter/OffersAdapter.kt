package com.example.amazonclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.amazonclone.data.OfferDeals
import com.example.amazonclone.data.SpecialDeals
import com.example.amazonclone.databinding.OffersRcviewLayoutBinding
import com.example.amazonclone.databinding.SpecialDealsLayoutBinding

class OffersAdapter: RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    private var offerItems:List<OfferDeals> = emptyList()

    class OffersViewHolder(private val binding: OffersRcviewLayoutBinding):ViewHolder(binding.root){

        fun bindOffers(item: OfferDeals){
            binding.apply {
                imgviewfirst1.setImageResource(item.firstImage)
                txtviewitem1.text = item.firstItem
                imgviewfirst2.setImageResource(item.secondImage)
                textView2.text = item.secondItem
                imgviewfirst3.setImageResource(item.thirdImage)
                textView3.text=item.thirdItem
                imgviewfirst4.setImageResource(item.fourthImage)
                textView4.text = item.fourthItem

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
       return OffersViewHolder(OffersRcviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return offerItems.size
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val currentoffer = offerItems[position]
        holder.bindOffers(currentoffer)
    }


    fun setOffers(offerDeals: List<OfferDeals>){
        this.offerItems = offerDeals
        notifyDataSetChanged()
    }
}