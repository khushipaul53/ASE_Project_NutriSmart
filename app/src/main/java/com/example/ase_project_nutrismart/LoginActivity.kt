package com.example.ase_project_nutrismart

import androidx.navigation.ui.AppBarConfiguration.Builder.setOpenableLayout
import androidx.navigation.ui.AppBarConfiguration.Builder.build
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.NavController.navigate
import androidx.navigation.ui.NavigationUI.navigateUp
import com.example.ase_project_nutrismart.Retrofit.APIClient.client
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel.data
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.sendSelectedGrocery
import com.example.ase_project_nutrismart.Response.SelectedGrocery.data
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.login
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.bmi
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.signup
import com.example.ase_project_nutrismart.Response.SignupResponse.message
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
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.ase_project_nutrismart.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class LoginActivity : AppCompatActivity() {
    var login: Button? = null
    var et_email: EditText? = null
    var et_password: EditText? = null
    var Login = ""
    var apiInterface: ApiInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login = findViewById(R.id.login)
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        apiInterface = client!!.create(ApiInterface::class.java)
        login.setOnClickListener(View.OnClickListener {
            if (validateFields()) {
                LoginApi()
            }
        })
    }

    private fun LoginApi() {
        val email = et_email!!.text.toString()
        val password = et_password!!.text.toString()
        val data: MutableMap<String?, String?> = HashMap()
        data["password"] = password
        data["usernameOrEmail"] = email
        val call = apiInterface!!.login(data)
        call!!.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
//                            Log.d("dfkflk",response.code()+"");
//                            LoginResponse loginResponse = response.code;
                Log.d("qwertyyyyy", "" + response.code())
                if (response.code() == 500) {
                    Toast.makeText(this@LoginActivity, "Bad Credentials", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Login Successfully", Toast.LENGTH_SHORT)
                        .show()
                    val signup = Intent(this@LoginActivity, HomeActvity::class.java)
                    startActivity(signup)
                }
                //                            Log.d("weidjf",""+loginResponse.getMessage());
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Log.d("falireirfi", "")
            } //
            //
        })
    }

    private fun validateFields(): Boolean {
        if (et_email!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show()
            return false
        } else if (et_password!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}