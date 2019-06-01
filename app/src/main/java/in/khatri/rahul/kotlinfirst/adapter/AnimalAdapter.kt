package `in`.khatri.rahul.kotlinfirst.adapter

import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.activity.ZooDetailActivity
import `in`.khatri.rahul.kotlinfirst.model.Animal
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.animal_killer_layout.view.*
import kotlinx.android.synthetic.main.animal_layout.view.*
import kotlinx.android.synthetic.main.animal_layout.view.iv_animal_image
import kotlinx.android.synthetic.main.animal_layout.view.ll_animal
import kotlinx.android.synthetic.main.animal_layout.view.tv_animal_description
import kotlinx.android.synthetic.main.animal_layout.view.tv_animal_name
import java.nio.file.Files.delete

class AnimalAdapter : BaseAdapter {
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
            myView.ll_animal.setOnClickListener {
                context!!.startActivity(Intent(context, ZooDetailActivity::class.java).putExtra("name", animal.name!!).putExtra("des", animal.des!!).putExtra("image", animal.image!!))

            }
            return myView
        } else {
            var myView = inflater.inflate(R.layout.animal_layout, null)
            myView.tv_animal_name.text = animal.name!!
            myView.tv_animal_description.text = animal.des!!
            myView.iv_animal_image.setImageResource(animal.image!!)
            myView.ll_animal.setOnClickListener {
                context!!.startActivity(Intent(context, ZooDetailActivity::class.java).putExtra("name", animal.name!!).putExtra("des", animal.des!!).putExtra("image", animal.image!!))
            }
            myView.iv_animal_image.setOnClickListener {
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