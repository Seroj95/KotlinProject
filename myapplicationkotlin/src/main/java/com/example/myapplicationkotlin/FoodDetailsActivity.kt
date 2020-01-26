package com.example.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detalis.*

class FoodDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detalis)
        loadDefaults()
    }

    private fun loadDefaults() {
        val bundle: Bundle? = intent.extras
        bundle?.let {
            ivFoodImage.setImageResource(it.getInt("image"))
            tvName.text = it.getString("name")
            tvDetalis.text = it.getString("desc")
        }
    }
}
