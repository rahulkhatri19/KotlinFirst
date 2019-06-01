package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.model.Animal
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_zoo.*
import kotlinx.android.synthetic.main.animal_killer_layout.view.*


class ZooActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter: AnimalAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoo)
        adapter = AnimalAdapter(this, listOfAnimals)
        listOfAnimals.add(Animal("Bulbasaur", "Bulbasaur is Pokemon with leaves", R.drawable.bulbasaur, false))
        listOfAnimals.add(Animal("Baboon", "Baboon is animal lives in Jungle", R.drawable.baboon, false))
        listOfAnimals.add(Animal("Bull Dog", "Bull Dog is animal lives in Jungle", R.drawable.bulldog, true))
        listOfAnimals.add(Animal("Panda", "Panda is animal lives in Jungle", R.drawable.panda, false))
        listOfAnimals.add(Animal("Swallow Bird", "Swallow Bird is animal lives in Jungle", R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal("White Tiger", "White Tiger is animal lives in Jungle", R.drawable.white_tiger, true))
        listOfAnimals.add(Animal("Zebra", "Zebra is animal lives in Jungle", R.drawable.zebra, false))


        listView.adapter = adapter
    }

    fun delete(index: Int) {
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()

    }

    inner class AnimalAdapter : BaseAdapter {
        var listAnimal = ArrayList<Animal>()
        var context: Context? = null

        constructor(mContext: Context, animalList: ArrayList<Animal>) : super() {
            this.listAnimal = animalList
            this.context = mContext
        }

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listAnimal[position]
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (animal.killer!!) {
                var myView = inflater.inflate(R.layout.animal_killer_layout, null)
                myView.tv_animal_name.text = animal.name!!
                myView.tv_animal_description.text = animal.des!!
                myView.iv_animal_image.setImageResource(animal.image!!)
                myView.iv_animal_image.setOnClickListener {
                    context!!.startActivity(Intent(context, ZooDetailActivity::class.java).putExtra("name", animal.name!!).putExtra("des", animal.des!!).putExtra("image", animal.image!!))
                }
                myView.iv_delete.setOnClickListener {
                    delete(position)
                }
                return myView
            } else {
                var myView = inflater.inflate(R.layout.animal_layout, null)
                myView.tv_animal_name.text = animal.name!!
                myView.tv_animal_description.text = animal.des!!
                myView.iv_animal_image.setImageResource(animal.image!!)
                myView.iv_animal_image.setOnClickListener {
                    context!!.startActivity(Intent(context, ZooDetailActivity::class.java).putExtra("name", animal.name!!).putExtra("des", animal.des!!).putExtra("image", animal.image!!))
                }
                myView.iv_delete.setOnClickListener {
                    delete(position)
                }

                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listAnimal[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listAnimal.size
        }

    }
}
