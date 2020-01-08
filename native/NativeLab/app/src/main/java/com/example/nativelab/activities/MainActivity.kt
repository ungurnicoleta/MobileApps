package com.example.nativelab.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nativelab.MyApi
import com.example.nativelab.R
import com.example.nativelab.database.AppDatabase
import com.example.nativelab.models.Food
import com.example.nativelab.models.Supplier
import com.example.nativelab.showToast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG = MainActivity::class.java.simpleName
        var id = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://192.168.1.5:1234")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val api = retrofit.create(MyApi::class.java)
//
//
//        api.getAllFoods().enqueue(object : Callback<List<Food>> {
//            override fun onFailure(call: Call<List<Food>>, t: Throwable) {
//                Log.d("bla bla", "onResponse")
//            }
//
//            override fun onResponse(call: Call<List<Food>>, response: Response<List<Food>>) {
//                Log.d("bla bla", "onFailure")
//            }
//        })

        addBtn.setOnClickListener {

            //Log.i(TAG, "The item was added!")
            showToast("The item was added!")
            val msg: String = myMsg.text.toString()
            Supplier.foods.add(Food(id, msg))
            id += 1

            val intent = Intent(this, ShoppingListActivity::class.java)

            intent.putExtra("user_msg", msg)

            startActivity(intent)
        }


        shareBtn.setOnClickListener() {
            val msg: String = myMsg.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, msg)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))

        }

        viewListBtn.setOnClickListener() {
            val intent = Intent(this, ShoppingListActivity::class.java)

            startActivity(intent)

        }
    }
}
