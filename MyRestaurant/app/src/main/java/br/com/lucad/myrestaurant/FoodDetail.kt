package br.com.lucad.myrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val bundle: Bundle? = intent.extras

        text_view_title_detail.text = bundle?.getString("title")
        text_view_description_detail.text = bundle?.getString("description")
        bundle?.getInt("image")?.let { image_view_details.setImageResource(it) }


    }
}