package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.models.MenuDatabase
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuItemDetailActivity : AppCompatActivity() {

    private val name: MaterialTextView by lazy { findViewById(R.id.detail_name) }
    private val image: ShapeableImageView by lazy { findViewById(R.id.detail_image) }
    private val description: MaterialTextView by lazy { findViewById(R.id.detail_description) }
    private val price: MaterialTextView by lazy { findViewById(R.id.detail_price) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        val dishId = intent.getIntExtra("dish_id", 0)
        val dish = MenuDatabase.getDishById(dishId + 1)!!

        name.text = dish.name
        image.setImageResource(dish.image)
        description.text = dish.description
        price.text = String.format("R$ %.2f", dish.price)
    }
}
