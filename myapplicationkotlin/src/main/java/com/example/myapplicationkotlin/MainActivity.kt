package com.example.myapplicationkotlin


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfFoods = Foods.getFoods()
        adapter = FoodAdapter(this, listOfFoods)
        gvListFood.adapter = adapter
    }
}


//lateinit var adapter =var adapter:FoodAdapter?=null

//val list= listOf(
//        PizzaRecipeItemK(R.drawable.ic_android_black_24dp,Utils.TITLE,Utils.DESCREPTION,Utils.RECEPT)
//
//)
//val layoutManager=LinearLayoutManager(this)
//adapter= PizzaRecipeAdapter(list as MutableList<PizzaRecipeItemK>)
//recyclerK.setHasFixedSize(true)
//recyclerK.layoutManager=layoutManager
//recyclerK.adapter=adapter
//}


//