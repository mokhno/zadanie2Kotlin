package com.example.kotlinapp3

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    val TAG: String = "tag"
    private var adressList: MutableList<Adress> = mutableListOf()

//private var recycler: RecyclerView =  recyclerID

    private val adressAdapter:AdressAdapter = AdressAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerID.layoutManager = LinearLayoutManager(applicationContext)
recyclerID.adapter= adressAdapter

        buttonAdd.setOnClickListener(View.OnClickListener {
            var adress: Adress = Adress()
            adress.setCity(editCity.getText().toString())
            adress.setCountry(editCountry.getText().toString())
            adressList.add(adress)
            Log.d(TAG, adressList.toString())

            adressAdapter.addData(adress)
        })

    }
}
