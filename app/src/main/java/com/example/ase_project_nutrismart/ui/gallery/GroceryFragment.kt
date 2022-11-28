package com.example.ase_project_nutrismart.ui.gallery

import com.example.ase_project_nutrismart.Retrofit.APIClient.client
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel.data
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.sendSelectedGrocery
import androidx.navigation.Navigation.findNavController
import androidx.navigation.NavController.navigate
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.groceryList
import com.example.ase_project_nutrismart.Response.Grocery
import androidx.recyclerview.widget.RecyclerView
import com.example.ase_project_nutrismart.Retrofit.ApiInterface
import com.example.ase_project_nutrismart.Response.PurchasedGrocery
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.ase_project_nutrismart.R
import com.example.ase_project_nutrismart.Retrofit.APIClient
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel
import com.example.ase_project_nutrismart.Response.SelectedGrocery
import androidx.navigation.NavController
import com.example.ase_project_nutrismart.Adapter.PurchasedGroceryAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class GroceryFragment : Fragment() {
    var groceryList: ArrayList<Grocery>? = ArrayList()
    var rvPurchased: RecyclerView? = null
    var apiInterface: ApiInterface? = null
    var purchasedGrocery: PurchasedGrocery? = null
    var nDialog: ProgressBar? = null
    var submit: Button? = null
    var selectedList = ArrayList<Grocery>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_gallery, container, false)
        rvPurchased = rootView.findViewById<View>(R.id.rv_pruchased) as RecyclerView
        apiInterface = client!!.create(ApiInterface::class.java)
        submit = rootView.findViewById(R.id.submit)
        nDialog = ProgressBar(context)
        purcharchedGroceryApi
        submit.setOnClickListener(View.OnClickListener { sendData() })
        return rootView
    }

    private fun sendData() {
        Log.d("qwertyh hjjn", "" + selectedList)
        sendPurchasedGroceryApi(selectedList)
    }

    private fun sendPurchasedGroceryApi(selectedList: ArrayList<Grocery>) {
        val model = SelectedGroceryModel()
        model.data = selectedList
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
                    navController.navigate(R.id.itemSlected)
                }
            }

            override fun onFailure(call: Call<SelectedGrocery?>, t: Throwable) {}
        })
    }

    //                purchasedGrocery=response.body().getData();
    private val purcharchedGroceryApi: Unit
    // Attach the adapter to the recyclerview to populate items
    // Set layout manager to position the items
    //data=purchasedGrocery.getData();
//               for(int i=0;i<data.size();i++)
//               {
//                   groceryList=response.body().getData();

        //               }
        private get() {
            val call = apiInterface!!.groceryList()
            call!!.enqueue(object : Callback<PurchasedGrocery> {
                override fun onResponse(
                    call: Call<PurchasedGrocery>,
                    response: Response<PurchasedGrocery>
                ) {
//                purchasedGrocery=response.body().getData();
                    val data = ArrayList<Grocery>()
                    groceryList = response.body().data
                    Log.d("dfkgg", "fk" + data.size)
                    nDialog!!.visibility = View.VISIBLE
                    val adapter = PurchasedGroceryAdapter(this@GroceryFragment, groceryList!!)
                    // Attach the adapter to the recyclerview to populate items
                    rvPurchased!!.adapter = adapter
                    // Set layout manager to position the items
                    rvPurchased!!.layoutManager = LinearLayoutManager(context)
                    //data=purchasedGrocery.getData();
//               for(int i=0;i<data.size();i++)
//               {
//                   groceryList=response.body().getData();

//               }
                    nDialog!!.visibility = View.GONE
                }

                override fun onFailure(call: Call<PurchasedGrocery>, t: Throwable) {}
            })
        }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun sendList(selectedItems: ArrayList<Grocery>) {
        selectedList = selectedItems
    }
}