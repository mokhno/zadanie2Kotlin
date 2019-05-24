package com.example.kotlinapp3


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdressAdapter : RecyclerView.Adapter<AdressHolder>() {

      interface OnItemClickListener{
        fun onItemClick(adress: Adress)
    }


private lateinit var listener:OnItemClickListener
    var adressList: MutableList<Adress> = mutableListOf()
    val TAG: String = "adapter"
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdressHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        val view: View = layoutInflater.inflate(R.layout.res_adress, p0, false)
        return AdressHolder(view)
    }

    override fun getItemCount(): Int {
        return adressList.size
    }

    override fun onBindViewHolder(p0: AdressHolder, p1: Int) {
        p0.bind(adressList[p1])
        p0.setListener(listener)
    }

    fun addData(adress: Adress) {
        Log.d(TAG, adressList.toString())
        adressList.add(adress)
        notifyDataSetChanged()
    }

fun setListener(onItemClickListener: OnItemClickListener){listener = onItemClickListener}


}

class AdressHolder(view: View) : RecyclerView.ViewHolder(view) {
    lateinit var adress:Adress
    private val city: TextView = view.findViewById(R.id.tvCity)
    private val country: TextView = view.findViewById(R.id.tvCountry)
    fun bind(adress: Adress) {
        city.text = adress.city
        country.text = adress.country
        this.adress = adress

    }

    fun setListener(listener: AdressAdapter.OnItemClickListener) {
itemView.setOnClickListener{listener.onItemClick(adress)}

    }


}
