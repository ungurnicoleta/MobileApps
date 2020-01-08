package com.example.nativelab.adapters
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nativelab.Constants
import com.example.nativelab.R
import com.example.nativelab.activities.SecondActivity
import com.example.nativelab.models.Food
import com.example.nativelab.models.Supplier
import com.example.nativelab.showToast
import kotlinx.android.synthetic.main.list_item.view.*



class ShoppingListAdapter(val context: Context, private val foods: List<Food>) :
    RecyclerView.Adapter<ShoppingListAdapter.MyViewHolder>() {

    companion object{
        val TAG = ShoppingListAdapter::class.java.simpleName

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val food = foods[position]
        holder.setData(food, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        private var currentFood: Food? = null
        var currentPosition: Int = 0

        init {
            itemView.txtTitle.setOnClickListener {
                context.showToast(currentFood!!.title + " was clicked")

            }

            itemView.imageButtonShare.setOnClickListener {
                val msg: String = "Food is: " + currentFood!!.title

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, msg)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }

            itemView.imageButtonDelete.setOnClickListener {
                val msg: String = "Food is: " + currentFood!!.title

                Supplier.foods.removeAt(currentPosition)
                notifyItemRemoved(currentPosition)
                notifyItemRangeChanged(currentPosition, Supplier.foods.size)
                notifyDataSetChanged()
            }

            itemView.imageButtonEdit.setOnClickListener {
                val msg: String = "Food is: " + currentFood!!.title
                val intent = Intent(context, SecondActivity::class.java)

                intent.putExtra(Constants.USER_MESSAGE_KEY, msg)
                intent.putExtra("position", currentPosition)
                context.startActivity(intent)
            }
        }


        fun setData(food: Food?, position: Int) {
            itemView.txtTitle.text = Editable.Factory.getInstance().newEditable(food!!.title)

            this.currentFood = food
            this.currentPosition = position
        }

        override fun onCreateContextMenu(menu: ContextMenu?, view: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            menu?.add(this.adapterPosition, R.id.imageButtonEdit, 1, "Edit")
            menu?.add(this.adapterPosition, R.id.imageButtonDelete, 2, "Delete")
        }
    }
}