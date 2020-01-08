package com.example.nativelab.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nativelab.Constants
import com.example.nativelab.R
import com.example.nativelab.models.Food
import com.example.nativelab.models.Supplier
import com.example.nativelab.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        EDIT.setOnClickListener {

            val msg: String = edit_item.text.toString()
            var bundle : Bundle? = intent.extras
            var pos = bundle!!.getInt(Constants.CURRENT_POS)
            var id  = 16
            Supplier.foods[pos] = Food(id,msg)
            id += 1
            //Log.i(TAG, "The item was added!")
            showToast("The item was updated!")

            val intent = Intent(this, ShoppingListActivity::class.java)

            intent.putExtra("user_msg", msg)

            startActivity(intent)
        }

    }
}