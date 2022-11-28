package com.example.ase_project_nutrismart.Response

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.ase_project_nutrismart.Response.BmiData
import com.example.ase_project_nutrismart.Response.ExpireData
import com.example.ase_project_nutrismart.Response.Grocery
import com.example.ase_project_nutrismart.Response.RolesResponse
import java.io.Serializable
import java.util.ArrayList

class SelectedGrocery : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "data")
    var data: ArrayList<Grocery>? = null

    @ColumnInfo(name = "purchaseDate")
    var purchasedDate: String? = null

    @ColumnInfo(name = "userEmail")
    var userEmail: String? = null
}