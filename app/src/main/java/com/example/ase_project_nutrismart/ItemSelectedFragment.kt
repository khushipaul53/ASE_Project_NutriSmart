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
import androidx.fragment.app.Fragment
import com.example.ase_project_nutrismart.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class ItemSelectedFragment : Fragment() {
    var apiInterface: ApiInterface? = null
    var RvSelectedItems: RecyclerView? = null
    var sendList: ArrayList<Grocery>? = ArrayList()
    var submit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_selected, container, false)
        apiInterface = client!!.create(ApiInterface::class.java)
        RvSelectedItems = view.findViewById(R.id.RvSelectedItems)
        submit = view.findViewById(R.id.submit)
        purchasedGroceryApi
        submit.setOnClickListener(View.OnClickListener { sendData() })
        // Inflate the layout for this fragment
        return view
    }

    private fun sendData() {
        val model = SelectedGroceryModel()
        model.data = sendList
        model.purchasedDate = "2022-11-13"
        model.userEmail = "sd@yopmail.com"
        val send = apiInterface!!.sendSelectedGrocery(model)
        send!!.enqueue(object : Callback<SelectedGrocery?> {
            override fun onResponse(
                call: Call<SelectedGrocery?>,
                response: Response<SelectedGrocery?>
            ) {
                Log.d("dkfkfg", "" + response.code())
                if (response.code() == 201) {
                    val navController =
                        findNavController(activity!!, R.id.nav_host_fragment_content_home_actvity)
                    navController.navigate(R.id.tracker)
                }
            }

            override fun onFailure(call: Call<SelectedGrocery?>, t: Throwable) {}
        })
    }
    // Attach the adapter to the recyclerview to populate items
    // Set layout manager to position the items

    //                if(response.code()==201)
//                {
//                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_home_actvity);
//                    navController.navigate(R.id.itemSlected);
//                }
    private val purchasedGroceryApi: Unit
        private get() {
            val model = SelectedGroceryModel()
            val list: ArrayList<Grocery?> = ArrayList<Any?>()
            model.data = list
            model.purchasedDate = "2022-11-13"
            model.userEmail = "sd@yopmail.com"
            val send = apiInterface!!.sendSelectedGrocery(model)
            send!!.enqueue(object : Callback<SelectedGrocery> {
                override fun onResponse(
                    call: Call<SelectedGrocery>,
                    response: Response<SelectedGrocery>
                ) {
                    Log.d("dkfkfg", "" + response.code())
                    sendList = response.body().data
                    val adapter =
                        SelectedGroceryAdapter(this@ItemSelectedFragment, response.body().data!!)
                    // Attach the adapter to the recyclerview to populate items
                    RvSelectedItems!!.adapter = adapter
                    // Set layout manager to position the items
                    RvSelectedItems!!.layoutManager = LinearLayoutManager(context)

//                if(response.code()==201)
//                {
//                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_home_actvity);
//                    navController.navigate(R.id.itemSlected);
//                }
                }

                override fun onFailure(call: Call<SelectedGrocery>, t: Throwable) {}
            })
        }
}