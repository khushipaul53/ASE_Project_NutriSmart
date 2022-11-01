package com.example.ase_project_nutrismart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ase_project_nutrismart.databinding.NavHeaderHomeActvityBinding;
import com.example.ase_project_nutrismart.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
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

    SharedPreferences pref;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
         editor = pref.edit();
        binding = ActivityHomeActvityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(nbinding.getRoot());
//        ivLogout=findViewById(R.id.ivLogout);
        setSupportActionBar(binding.appBarHomeActvity.toolbar);

        editor.putString("isLogin", "200");
        editor.commit();
//        Bundle bundle = new Bundle();
//        String name=bundle.getString("name");
//
//        bundle.putString("name_frag",name);
//// set Fragmentclass Arguments
//        HomeFragment fragobj = new HomeFragment();
//        fragobj.setArguments(bundle);


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
                R.id.tracker, R.id.grocery, R.id.expiry)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_actvity);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id= item.getItemId();

                switch (id){
                    case R.id.nav_expiry:
//                        navController.navigate(R.id.expiry);
                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_tracker:
//                        navController.navigate(R.id.tracker);
//                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();

                        drawer.closeDrawer(GravityCompat.START);
                        break;

//                    case R.id.nav_profile:
////                        navController.navigate(R.id.profile);
//                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();
//
//                        drawer.closeDrawer(GravityCompat.START);
//                        break;

                    case R.id.nav_grocery:
//                        navController.navigate(R.id.grocery);
                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();

                        drawer.closeDrawer(GravityCompat.START); 
                        break;

                    case R.id.nav_logout:
                       
                        alertBox();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                
                
                return false;
            }
        });

//



    }


    private void alertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActvity.this);
//
                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog


                        Intent intent=new Intent(HomeActvity.this,SplashActivity.class);
//                        onBackPressed();
                       editor.putString("isLogin","0");
                        editor.commit();
                        startActivity(intent);

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
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