package `in`.khatri.rahul.kotlinfirst.adapter

import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.activity.RestaurantDetailActivity
import `in`.khatri.rahul.kotlinfirst.model.Food
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.food_item.view.*

class FoodAdapter : BaseAdapter {
    var list= ArrayList<Food>()
    var context:Context?= null

    constructor(mContext:Context, mList:ArrayList<Food>) : super() {
        this.context= mContext
        this.list= mList
    }
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var food= list[position]
        val inflater= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val myView= inflater.inflate( R.layout.food_item, null)

        myView.tv_name.text = food.name!!
        myView.iv_food.setImageResource(food.image!!)
        myView.ll_food.setOnClickListener {
            context!!.startActivity(Intent(context, RestaurantDetailActivity::class.java).putExtra("name", food.name!!).putExtra("des", food.des!!).putExtra("image",
                food.image!!))
        }
        return myView
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return list.size
    }

}