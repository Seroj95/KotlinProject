package com.example.myapplicationkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.foot_ticket_item.view.*

class FoodAdapter(private val context: Context, private val foods: List<Food>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = foods[position]
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val foodView = inflater.inflate(R.layout.foot_ticket_item, null)
        foodView.ivFoodImage.setImageResource(food.image)
        foodView.ivFoodImage.setOnClickListener(getFoodImageClickListener(food))
        foodView.tvName.text = food.name
        return foodView
    }

    private fun getFoodImageClickListener(food: Food): View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(context, FoodDetailsActivity::class.java)
            intent.putExtra("name", food.name)
            intent.putExtra("desc", food.des)
            intent.putExtra("image", food.image)
            context.startActivity(intent)
        }
    }

    override fun getItem(position: Int): Any {
        return foods[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return foods.size
    }
}