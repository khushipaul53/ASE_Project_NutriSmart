package com.example.ase_project_nutrismart.Response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ase_project_nutrismart.Response.BmiData
import com.example.ase_project_nutrismart.Response.ExpireData
import com.example.ase_project_nutrismart.Response.Grocery
import com.example.ase_project_nutrismart.Response.RolesResponse
import java.io.Serializable

@Entity
class ExpireData : Serializable {
    @ColumnInfo(name = "insertionNumber")
    var insertionNumber = 0

    @ColumnInfo(name = "id")
    var id: String? = null

    @ColumnInfo(name = "food")
    var food: String? = null

    @ColumnInfo(name = "userEmail")
    var userEmail = 0

    @ColumnInfo(name = "purchaseDate")
    var purchaseDate: String? = null

    @ColumnInfo(name = "expiryDate")
    var expiryDate: String? = null
}