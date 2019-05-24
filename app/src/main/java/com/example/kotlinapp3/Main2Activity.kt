package com.example.kotlinapp3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    val ITEM = "ITEM"
    lateinit var adress: Adress
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var intent: Intent = intent

        adress = intent.getParcelableExtra(ITEM)
        edit_city.setText(adress.city)
        edit_country.setText(adress.country)


buttonSave.setOnClickListener {
    adress.city = edit_city.text.toString()
    adress.country = edit_country.text.toString()
    val intent = Intent(this, MainActivity::class.java)
    intent.putExtra("ITEM2", adress)
    setResult(Activity.RESULT_OK)
    finish()
}

    }
}
