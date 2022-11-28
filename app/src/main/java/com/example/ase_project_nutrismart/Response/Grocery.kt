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
class Grocery : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "food")
    var food: String? = null

    @ColumnInfo(name = "measure")
    var measure: String? = null

    @ColumnInfo(name = "measuringUnit")
    var measuringUnit: String? = null

    @ColumnInfo(name = "grams")
    var grams: String? = null

    @ColumnInfo(name = "calories")
    var calories: String? = null

    @ColumnInfo(name = "protein")
    var protein: String? = null

    @ColumnInfo(name = "fat")
    var fat: String? = null

    @ColumnInfo(name = "sno")
    var sno = 0

    @ColumnInfo(name = "fibers")
    var fibers: String? = null

    @ColumnInfo(name = "saturatedFat")
    var saturatedFat: String? = null

    @ColumnInfo(name = "category")
    var category: String? = null

    @ColumnInfo(name = "carbs")
    var carbs: String? = null
}