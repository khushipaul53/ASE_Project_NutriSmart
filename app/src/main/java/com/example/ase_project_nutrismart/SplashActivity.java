package com.example.ase_project_nutrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.window.SplashScreen;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("LOGIN", true);

        editor.commit();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
//                if (prefs.getBoolean("LOGIN", true)) {
//                    Intent i = new Intent(SplashActivity.this,HomeActvity.class);
//                    startActivity(i);
//                }
//                else{
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
//                }



                // close this activity
                finish();
            }
        }, 3000);


    }
}