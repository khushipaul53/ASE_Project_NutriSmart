package com.example.ase_project_nutrismart;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.example.ase_project_nutrismart.databinding.NavHeaderHomeActvityBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ase_project_nutrismart.databinding.ActivityHomeActvityBinding;

public class HomeActvity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeActvityBinding binding;
    private ImageView ivLogout;
    private NavHeaderHomeActvityBinding nbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeActvityBinding.inflate(getLayoutInflater());
        nbinding=NavHeaderHomeActvityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(nbinding.getRoot());
//        ivLogout=findViewById(R.id.ivLogout);
        setSupportActionBar(binding.appBarHomeActvity.toolbar);
//        nbinding.ivLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActvity.this);
//
//                builder.setTitle("Confirm");
//                builder.setMessage("Are you sure?");
//
//                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Do nothing but close the dialog
//
//
//                        Intent intent=new Intent(HomeActvity.this,MainActivity.class);
//                        startActivity(intent);
//                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(HomeActvity.this);
//                        SharedPreferences.Editor editor = prefs.edit();
//                        editor.putBoolean("LOGIN",true);
//                        dialog.dismiss();
//                    }
//                });
//
//                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        // Do nothing
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        });

        binding.appBarHomeActvity.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_tracker, R.id.nav_grocery, R.id.nav_expiry,R.id.nav_profile)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_actvity);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//        navController.navigate(R.layout.nav_header_home_actvity)..findViewById(R.id.ivLogout).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActvity.this);
//
//                builder.setTitle("Confirm");
//                builder.setMessage("Are you sure?");
//
//                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Do nothing but close the dialog
//
//
//                        Intent intent=new Intent(HomeActvity.this,MainActivity.class);
//                        startActivity(intent);
//                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(HomeActvity.this);
//                        SharedPreferences.Editor editor = prefs.edit();
//                        editor.putBoolean("LOGIN",true);
//                        dialog.dismiss();
//                    }
//                });
//
//                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        // Do nothing
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_actvity, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_actvity);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}