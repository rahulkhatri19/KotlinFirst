package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.adapter.FoodAdapter
import `in`.khatri.rahul.kotlinfirst.model.Food
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity() {

    var listOfFood= ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        listOfFood.add(Food("Coffee","By now, you have a winning strategy for how you will use content to grow your business… an effective idea-generating system in place… and an editorial plan for the content you'll create over the next few months, give or take.",R.drawable.coffee_pot))
        listOfFood.add(Food("Espresso","And that's exactly what you'll get in this chapter. Here we cover the six steps of the creative process, in depth and with specific examples showing you how to turn your idea into a finished piece of content.",R.drawable.espresso))
        listOfFood.add(Food("French Fries","Just to be clear: In this chapter, we talk primarily about how to write content. That doesn't mean we think you ought to be creating blog posts only or that written content is somehow better.",R.drawable.french_fries))
        listOfFood.add(Food("Honey","It's just that all content ultimately starts with the written word. The steps you take to present your ideas in a video are the same as you'd use in an article. It's only in production that things change.\n",R.drawable.honey))
        listOfFood.add(Food("Strawberry","That's because not all content producers consider themselves writers. But each time you produce a new piece of content — whether it's a blog post, podcast or video — you follow the same process of organizing your ideas and finding the right words to express yourself.",R.drawable.strawberry_ice_cream))
        listOfFood.add(Food("Sugar Cubes","Any time you sit down to produce a new piece of content, you'll use these steps. You won't always work through them in order, and sometimes you'll jump back and forth between steps.",R.drawable.sugar_cubes))

        gv_food.adapter=  FoodAdapter(this, listOfFood)

    }
}
