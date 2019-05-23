package com.example.kotlinapp3

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private val adressAdapter: AdressAdapter = AdressAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerID.layoutManager = LinearLayoutManager(applicationContext)
        recyclerID.adapter = adressAdapter

        buttonAdd.setOnClickListener {
            var matchCounter: Int = 0
            var adress: Adress = Adress(editCity.text.toString(), editCountry.text.toString(), UUID.randomUUID().toString())
          if ( adressAdapter.adressList.isEmpty()) {
              adressAdapter.addData(adress)

          }else {
              for (a in adressAdapter.adressList.indices) {
                  if ((adress.city == adressAdapter.adressList[a].city) && (adress.country == adressAdapter.adressList[a].country)) {
                      matchCounter++
                  }
              }
              if (matchCounter > 0 ) {
                  Toast.makeText(this, "Добавляемы город уже существует", Toast.LENGTH_SHORT).show()
              }
              else adressAdapter.addData(adress)
          }

        }

    }
}
