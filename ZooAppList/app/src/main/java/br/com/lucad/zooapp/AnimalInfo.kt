package br.com.lucad.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle:Bundle? = intent.extras
        val name: String? = bundle?.getString("name")
        val description: String? = bundle?.getString("description")
        val image = bundle?.getInt("image")

        imageview_info.setImageResource(image!!)
        textview_info_title.text = name
        textview_info_description.text = description
    }
}