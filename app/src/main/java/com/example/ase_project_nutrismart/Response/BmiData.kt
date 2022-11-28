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
class BmiData : Serializable {
    fun getbMI(): Double {
        return bMI
    }

    fun setbMI(bMI: Double) {
        this.bMI = bMI
    }

    @JvmField
    @ColumnInfo(name = "bMI")
    var bMI = 0.0

    @JvmField
    @ColumnInfo(name = "proteinNeeded")
    var proteinNeeded = 0.0

    @JvmField
    @ColumnInfo(name = "carbsNeeded")
    var carbsNeeded = 0.0

    @JvmField
    @ColumnInfo(name = "fatsNeeded")
    var fatsNeeded = 0.0

    @JvmField
    @ColumnInfo(name = "calorie")
    var calorie = 0.0
}