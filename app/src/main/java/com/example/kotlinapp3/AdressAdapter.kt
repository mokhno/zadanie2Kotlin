package com.example.kotlinapp3


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdressAdapter : RecyclerView.Adapter<AdressHolder>() {
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
    }

    fun addData(adress: Adress) {
        Log.d(TAG, adressList.toString())
        adressList.add(adress)
        notifyDataSetChanged()
    }

}

class AdressHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val city: TextView = view.findViewById(R.id.tvCity)
    private val country: TextView = view.findViewById(R.id.tvCountry)
    fun bind(adress: Adress) {
        city.text = adress.city
        country.text = adress.country
    }


}
