package com.example.ase_project_nutrismart

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.ActivityNavigator
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.ase_project_nutrismart.databinding.ActivityHomeActvityBinding
import com.google.android.material.snackbar.Snackbar

class HomeActvity : AppCompatActivity() {
    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private var binding: ActivityHomeActvityBinding? = null
   lateinit var  pref: SharedPreferences
    lateinit var  editor: SharedPreferences.Editor
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
        mAppBarConfiguration = AppBarConfiguration.Builder(
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