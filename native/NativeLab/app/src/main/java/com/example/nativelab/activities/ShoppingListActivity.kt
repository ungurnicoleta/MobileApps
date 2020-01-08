package com.example.nativelab.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nativelab.R
import com.example.nativelab.adapters.ShoppingListAdapter
import com.example.nativelab.models.Supplier
import kotlinx.android.synthetic.main.activity_listview.*

class ShoppingListActivity : AppCompatActivity()  {
    lateinit var alertDialog : AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter =
            ShoppingListAdapter(this, Supplier.foods)
        recyclerView.adapter = adapter
    }
}