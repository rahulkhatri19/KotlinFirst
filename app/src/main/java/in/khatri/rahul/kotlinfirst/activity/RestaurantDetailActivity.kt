package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class RestaurantDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

//        tv_name.text = intent.getStringExtra("name")
//        tv_des.text = intent.getStringExtra("des")
//        iv_food.setImageResource(intent.getIntExtra("image", R.drawable.coffee_pot))

        val bundle = intent.extras

        tv_name.text = bundle?.getString("name")
        tv_des.text = bundle?.getString("des")
        iv_food.setImageResource(bundle.getInt("image"))
    }
}
