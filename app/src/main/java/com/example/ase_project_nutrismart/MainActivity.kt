package com.example.ase_project_nutrismart


import com.example.ase_project_nutrismart.Retrofit.APIClient.client

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.example.ase_project_nutrismart.R
import androidx.navigation.NavController
import androidx.core.view.GravityCompat
import android.content.DialogInterface
import android.content.Intent
import com.example.ase_project_nutrismart.SplashActivity
import com.example.ase_project_nutrismart.Retrofit.ApiInterface
import androidx.recyclerview.widget.RecyclerView
import com.example.ase_project_nutrismart.Response.Grocery
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ase_project_nutrismart.Retrofit.APIClient
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel
import com.example.ase_project_nutrismart.Response.SelectedGrocery
import com.example.ase_project_nutrismart.Adapter.SelectedGroceryAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.EditText
import com.example.ase_project_nutrismart.Response.LoginResponse
import android.widget.Toast
import com.example.ase_project_nutrismart.HomeActvity
import com.example.ase_project_nutrismart.SignupActivity
import com.example.ase_project_nutrismart.LoginActivity
import com.example.ase_project_nutrismart.ProfileFragment
import android.app.DatePickerDialog.OnDateSetListener
import android.app.DatePickerDialog
import android.widget.ArrayAdapter
import com.example.ase_project_nutrismart.Response.BmiResponse
import kotlin.Throws
import com.example.ase_project_nutrismart.Response.SignupResponse
import android.os.Looper
import android.view.View
import android.widget.Button
import com.example.ase_project_nutrismart.MainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_create_new_user:Button
        var btn_login:Button

        btn_create_new_user = findViewById(R.id.btn_create_new_user)
        btn_login = findViewById(R.id.btn_login)
        val b = Bundle()
        b.getString("isLogin")
       var apiInterface = client!!.create(ApiInterface::class.java)
        btn_create_new_user.setOnClickListener(View.OnClickListener {
            val signup = Intent(this@MainActivity, SignupActivity::class.java)
            startActivity(signup, b)
        })
        btn_login.setOnClickListener(View.OnClickListener { //
            val login = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(login, b)
        })
    }
}