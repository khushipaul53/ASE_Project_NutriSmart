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
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import com.example.ase_project_nutrismart.MainActivity
import com.example.ase_project_nutrismart.databinding.ActivityHomeActvityBinding

class HomeActvity : AppCompatActivity() {
    private var mAppBarConfiguration: AppBarConfiguration? = null
    private var binding: ActivityHomeActvityBinding? = null
    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("PREFS", MODE_PRIVATE)
        editor = pref.edit()
        binding = ActivityHomeActvityBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        //        setContentView(nbinding.getRoot());
//        ivLogout=findViewById(R.id.ivLogout);
        setSupportActionBar(binding!!.appBarHomeActvity.toolbar)
        editor.putString("isLogin", "200")
        editor.commit()

//        Bundle bundle = getIntent().getExtras();
//        Boolean b=bundle.getBoolean("isSingup");
//        if(b){
//        String bmi=bundle.getString("bmi");
//        String proteinNeeded=bundle.getString("proteinNeeded");
//        String carbsNeeded=bundle.getString("carbsNeeded");
//        String calorie=bundle.getString("calorie");
//Log.d("cmvnbvn",""+bmi+" "+proteinNeeded+" "+carbsNeeded+" "+calorie);}


//        bundle.putString("name_frag",name);
// set Fragment   class Arguments
//        HomeFragment fragobj = new HomeFragment();
//        fragobj.setArguments(bundle);
        binding!!.appBarHomeActvity.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawer = binding!!.drawerLayout
        val navigationView = binding!!.navView

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = Builder(
            R.id.tracker, R.id.grocery, R.id.expiry
        )
            .setOpenableLayout(drawer)
            .build()
        val navController = findNavController(this, R.id.nav_host_fragment_content_home_actvity)
        setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        //        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.nav_expiry -> {
                    navController.navigate(R.id.expiry)
                    //                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_tracker -> //                        navController.navigate(R.id.tracker);
//                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START)
                R.id.nav_grocery -> {
                    navController.navigate(R.id.grocery)
                    //                        Toast.makeText(HomeActvity.this,"In Progress",Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_logout -> {
                    alertBox()
                    drawer.closeDrawer(GravityCompat.START)
                }
            }
            false
        }

//
    }

    private fun alertBox() {
        val builder = AlertDialog.Builder(this@HomeActvity)
        //
        builder.setTitle("Confirm")
        builder.setMessage("Are you sure?")
        builder.setPositiveButton("YES") { dialog, which -> // Do nothing but close the dialog
            val intent = Intent(this@HomeActvity, SplashActivity::class.java)
            //                        onBackPressed();
            editor!!.putString("isLogin", "0")
            editor!!.commit()
            startActivity(intent)
            dialog.dismiss()
        }
        builder.setNegativeButton("NO") { dialog, which -> // Do nothing
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home_actvity, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this, R.id.nav_host_fragment_content_home_actvity)
        return (navigateUp(navController, mAppBarConfiguration!!)
                || super.onSupportNavigateUp())
    }
}