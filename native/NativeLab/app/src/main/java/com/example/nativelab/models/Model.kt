package com.example.nativelab.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_items")
data class Food(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "title") var title: String
)


object Supplier{
    val foods = arrayListOf<Food>(
        Food(1,"Apple"),
        Food(2,"Banana"),
        Food(3,"Avocado"),
        Food(4,"Coffee"),
        Food(5,"Bread"),
        Food(6,"Cream"),
        Food(7,"Steak"),
        Food(8,"Water"),
        Food(9,"Strawberry"),
        Food(10,"Lemon"),
        Food(11,"Melon"),
        Food(12,"Onion"),
        Food(13,"EggPlant"),
        Food(14,"Potatoes"),
        Food(15,"Tomatoes"),
        Food(16,"Milk"),
        Food(17,"Chocolate"),
        Food(18,"Juice"),
        Food(19,"Sweets"),
        Food(20,"Cake")
    )
}