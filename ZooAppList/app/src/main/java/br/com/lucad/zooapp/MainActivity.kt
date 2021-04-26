package br.com.lucad.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
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
            Animal("Baboon", "Baboon lives there", R.drawable.baboon, false))
        listOfAnimals.add(
            Animal("Bulldog", "Bulldog lives there in city", R.drawable.bulldog, false))
        listOfAnimals.add(
            Animal("Panda", "Panda lives in Japan", R.drawable.panda, false))
        listOfAnimals.add(
            Animal("Zebra", "Zebra lives there in Africa", R.drawable.zebra, false))
        listOfAnimals.add(
            Animal("White Tiger", "White Tiger lives there in Jungle", R.drawable.white_tiger, true))
        listOfAnimals.add(
            Animal("Swallow Bird", "Swallow Bird lives there", R.drawable.swallow_bird, false))
        adapter = AnimalsAdapter(this, listOfAnimals)
        textview_list_animal.adapter = adapter
    }

    fun delete(index: Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

   inner class AnimalsAdapter(context: Context, listOfAnimals: ArrayList<Animal>):BaseAdapter(){
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
            var myView: View
            if(animal.isKiller == true){
                var inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.textview_name.text = animal.name
                myView.textview_description.text = animal.description
                myView.imageview_animal.setImageResource(animal.image!!)
                myView.setOnLongClickListener {
                    delete(position)
                    return@setOnLongClickListener true
                }
                myView.setOnClickListener {
                    delete(position)
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("description", animal.description!!)
                    intent.putExtra("image", animal.image!!)
                    context.startActivity(intent)
                }
            }else{
                var inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.textview_name.text = animal.name
                myView.textview_description.text = animal.description
                myView.imageview_animal.setImageResource(animal.image!!)
                myView.setOnLongClickListener {
                    delete(position)
                    return@setOnLongClickListener true
                }
                myView.setOnClickListener {
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("description", animal.description!!)
                    intent.putExtra("image", animal.image!!)
                    context.startActivity(intent)

                }
            }

            return  myView
        }
    }

}