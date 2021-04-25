package br.com.lucad.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listOfAnimals.add(
            Animal("Baboon", "Baboon lives there", R.drawable.baboon))
        listOfAnimals.add(
            Animal("Bulldog", "Bulldog lives there in city", R.drawable.bulldog))
        listOfAnimals.add(
            Animal("Panda", "Panda lives in Japan", R.drawable.panda))
        listOfAnimals.add(
            Animal("Zebra", "Zebra lives there in Africa", R.drawable.zebra))
        listOfAnimals.add(
            Animal("White Tiger", "White Tiger lives there in Jungle", R.drawable.white_tiger))
        listOfAnimals.add(
            Animal("Swallow Bird", "Swallow Bird lives there", R.drawable.swallow_bird))
        adapter = AnimalsAdapter(this, listOfAnimals)
        textview_list_animal.adapter = adapter
    }

    class AnimalsAdapter(context: Context, listOfAnimals: ArrayList<Animal>):BaseAdapter(){
        var listOfAnimals = ArrayList<Animal>()
        var context = context

        init {
            this.listOfAnimals = listOfAnimals
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            var inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.animal_ticket, null)
            myView.textview_name.text = animal.name
            myView.textview_description.text = animal.description
            myView.imageview_animal.setImageResource(animal.image!!)
            return  myView
        }
    }

}