package com.example.ase_project_nutrismart


import com.example.ase_project_nutrismart.Retrofit.APIClient.client

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.content.Intent
import com.example.ase_project_nutrismart.Retrofit.ApiInterface

import android.widget.EditText
import com.example.ase_project_nutrismart.Response.LoginResponse
import android.widget.Toast

import android.util.Log
import android.view.View
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class LoginActivity : AppCompatActivity() {
    lateinit var login: Button
    lateinit var  et_email: EditText
    lateinit var  et_password: EditText
     var  Login = ""
    lateinit var  apiInterface: ApiInterface
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