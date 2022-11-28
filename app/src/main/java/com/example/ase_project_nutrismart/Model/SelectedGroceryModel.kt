package com.example.ase_project_nutrismart.Model

import androidx.room.PrimaryKey
import com.example.ase_project_nutrismart.Response.Grocery
import androidx.room.ColumnInfo
import java.util.ArrayList

class SelectedGroceryModel {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "data")
    var data: ArrayList<Grocery>? = null

    @JvmField
    @ColumnInfo(name = "purchaseDate")
    var purchasedDate: String? = null

    @JvmField
    @ColumnInfo(name = "userEmail")
    var userEmail: String? = null
}