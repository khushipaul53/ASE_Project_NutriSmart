package com.example.ase_project_nutrismart.Response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ase_project_nutrismart.Response.BmiData
import com.example.ase_project_nutrismart.Response.ExpireData
import com.example.ase_project_nutrismart.Response.Grocery
import com.example.ase_project_nutrismart.Response.RolesResponse
import java.io.Serializable
import java.util.ArrayList

@Entity
class PurchasedGrocery : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @JvmField
    @ColumnInfo(name = "data")
    var data: ArrayList<Grocery>? = null
}