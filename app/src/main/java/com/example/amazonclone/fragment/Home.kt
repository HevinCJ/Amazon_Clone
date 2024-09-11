package com.example.amazonclone.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazonclone.R
import com.example.amazonclone.adapter.AmazonPayAdapter
import com.example.amazonclone.adapter.ImageSliderAdapter
import com.example.amazonclone.adapter.OffersAdapter
import com.example.amazonclone.adapter.ServiceAdapter
import com.example.amazonclone.adapter.SpecialDealsAdapter
import com.example.amazonclone.data.ItemModel
import com.example.amazonclone.data.OfferDeals
import com.example.amazonclone.data.SearchItem
import com.example.amazonclone.data.SpecialDeals
import com.example.amazonclone.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Home : Fragment() {


    private var Home: FragmentHomeBinding?=null
    private val binding get() = Home!!


    private val serviceAdapter: ServiceAdapter by lazy { ServiceAdapter() }

    private val amazonPayAdapter: AmazonPayAdapter by lazy { AmazonPayAdapter() }

    private val imageSliderAdapter: ImageSliderAdapter by lazy { ImageSliderAdapter() }

    private val specialDealAdapter:SpecialDealsAdapter by lazy { SpecialDealsAdapter() }

    private val offersAdapter:OffersAdapter by lazy { OffersAdapter() }

    private var currentTab = 0
    private val handler = Handler(Looper.getMainLooper())






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Home = FragmentHomeBinding.inflate(inflater,container,false)


        setRecylerview()
        setAmazonPayAdapter()
        setRecyclerviewDealsForYou()
        setRcViewOffers()



        val items = listOf(
            ItemModel("Shop Live", R.drawable.livevideo),
            ItemModel("Movies", R.drawable.watchingamovie),
            ItemModel("Prime", R.drawable.icons8amazonprime48),
            ItemModel("Deals", R.drawable.deal),
            ItemModel("MiniTv", R.drawable.television),
            ItemModel("Mobiles", R.drawable.iphone),
            ItemModel("Fashion", R.drawable.fashionmerchandising),
            ItemModel("Electronics", R.drawable.electronics),
            ItemModel("Bazaar", R.drawable.bazaar),
            ItemModel("Beauty", R.drawable.products),
            ItemModel("Pharmacy", R.drawable.medicine),
            ItemModel("More", R.drawable.more)
        )
        serviceAdapter.setData(items)


        val images = listOf(
            R.drawable.flightoffer,
            R.drawable.cinema,
            R.drawable.samsung,
            R.drawable.boat
        )

        binding.viewpgrmain.adapter = imageSliderAdapter
        imageSliderAdapter.setImage(images)

        val listOfSearches = listOf(
            SearchItem("Soaps", R.drawable.soap),
            SearchItem("Camera", R.drawable.camera)
        )

        binding.let {
            amazonPayAdapter.setData(listOfSearches)
        }



        val deals = listOf(SpecialDeals("20",R.drawable.soapdeals,"35",R.drawable.vivodeal,"45",R.drawable.pressurecookerdeals,"50",R.drawable.glassdeals))
        specialDealAdapter.setDeals(deals)

        val offers = listOf(OfferDeals("Starting \n  ₹1,667/month |Month",R.drawable.iqoo9s,"Up to 70% off | \n Exchange offers on laptops ",R.drawable.macbook,"Extra up to 12,000 off | \n Premium appliances",R.drawable.homeappliances,"Starting ₹5,499 | Smart \n TVs",R.drawable.tv))
        offersAdapter.setOffers(offers)

        binding.let {
            TabLayoutMediator(it.tablytmain,it.viewpgrmain){tab,position ->
                tab.setIcon(R.drawable.tab_indicator_unselected)

            }.attach()
        }

        binding.let {
            it.tablytmain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.setIcon(R.drawable.tab_indicator_selected)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    tab?.setIcon(R.drawable.tab_indicator_unselected)
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    tab?.setIcon(R.drawable.tab_indicator_selected)
                }

            })


        }



        startAutoTabChange()

        setVideoView()
        return binding.root
    }

    private fun setRcViewOffers() {

        binding.apply {
            rcviewoffers.adapter = offersAdapter
            rcviewoffers.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setRecyclerviewDealsForYou() {
        binding.apply {
            rcviewdealsforyou.adapter = specialDealAdapter
            rcviewdealsforyou.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setVideoView() {
        val videoUri = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.vazha}")
        binding.apply {
            videoview.setVideoURI(videoUri)
            videoview.requestFocus()

            videoview.setOnPreparedListener {mp->
                mp.start()
            }
        }





    }

    private fun startAutoTabChange() {

        val runnable = object :Runnable {
            override fun run() {

                val tabLayout = binding.tablytmain
                val viewpager = binding.viewpgrmain

                currentTab = (currentTab+1)%tabLayout.tabCount

                viewpager.currentItem = currentTab

                handler.postDelayed(this,4000)
            }

        }

        handler.postDelayed(runnable,4000)
    }

    private fun setRecylerview() {
        binding.rcviewservices.adapter =serviceAdapter
        binding.rcviewservices.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setAmazonPayAdapter(){
        binding.let {
            it.rcviewamazonpay.adapter = amazonPayAdapter
            it.rcviewamazonpay.layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
        }
    }


}