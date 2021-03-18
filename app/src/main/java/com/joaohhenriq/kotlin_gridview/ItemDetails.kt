package com.joaohhenriq.kotlin_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item_details.*

class ItemDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        loadScreen()
    }

    fun loadScreen() {
        val bundle = intent.extras

        imageViewDetail.setImageResource(bundle!!.getInt("image"))
        textViewName.text = bundle!!.getString("name")
        textViewDescription.text = bundle!!.getString("des")
    }
}