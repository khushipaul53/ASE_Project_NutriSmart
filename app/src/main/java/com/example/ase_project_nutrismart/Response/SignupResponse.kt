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
class SignupResponse : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "message")
    var message: String? = null
}