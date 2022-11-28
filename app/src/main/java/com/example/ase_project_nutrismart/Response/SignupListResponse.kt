package com.example.ase_project_nutrismart.Response

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.ase_project_nutrismart.Response.BmiData
import com.example.ase_project_nutrismart.Response.ExpireData
import com.example.ase_project_nutrismart.Response.Grocery
import com.example.ase_project_nutrismart.Response.RolesResponse

class SignupListResponse {
    @PrimaryKey(autoGenerate = true)
    var id: String? = null
    var name: String? = null
    var activity_level: String? = null
    var username: String? = null
    var email: String? = null
    var password: String? = null
    var gender: String? = null
    var height: String? = null
    var age: String? = null
    var weight: String? = null
    var role: List<RolesResponse>? = null
}

class RolesResponse {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var role_name: String? = null
}