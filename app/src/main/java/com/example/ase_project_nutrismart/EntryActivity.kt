package com.example.ase_project_nutrismart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)




        var pref = getSharedPreferences("PREFS", MODE_PRIVATE)
        val editor = pref.edit()

//        editor.putString("isLogin", "0");
        editor.commit()
        Handler(Looper.getMainLooper()).postDelayed({ // This method will be executed once the timer is over
            // Start your app main activity
            if (pref.getString("isLogin", "") == "200") {
                val i = Intent(this, HomeActvity::class.java)
                val bundle = Bundle()
                bundle.putBoolean("isSingup", false)
                startActivity(i, bundle)
            } else {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }


            // close this activity
            finish()
        }, 2000)
    }
    }
