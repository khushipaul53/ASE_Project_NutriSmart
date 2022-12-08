package com.example.ase_project_nutrismart.ui.slideshow

import com.example.ase_project_nutrismart.Retrofit.APIClient.client

import com.example.ase_project_nutrismart.Retrofit.ApiInterface
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ase_project_nutrismart.R
import com.example.ase_project_nutrismart.Retrofit.APIClient
import com.example.ase_project_nutrismart.Response.ExpiryResponse
import com.example.ase_project_nutrismart.Response.ExpireData
import com.example.ase_project_nutrismart.Adapter.ExpireAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExpireFragment : Fragment() {
    var apiInterface: ApiInterface? = null
    var rv_expire: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_expire, container, false)
        apiInterface = client!!.create(ApiInterface::class.java)
        rv_expire = rootView.findViewById(R.id.rv_expire)
        expireData
        return rootView
    }// Attach the adapter to the recyclerview to populate items
    // Set layout manager to position the items


    //data=purchasedGrocery.getData();
    //    ArrayList<ExpireData>data=new ArrayList<>();
    private val expireData: Unit
        private get() {
            val call = apiInterface!!.getExpiryList("test2@yopmail.com")
            call!!.enqueue(object : Callback<ExpiryResponse?> {
                override fun onResponse(
                    call: Call<ExpiryResponse?>,
                    response: Response<ExpiryResponse?>
                ) {
                    val data = response.body()!!.data
                    val adapter = ExpireAdapter(this@ExpireFragment, data!!)
                    // Attach the adapter to the recyclerview to populate items
                    rv_expire!!.adapter = adapter
                    // Set layout manager to position the items
                    rv_expire!!.layoutManager = LinearLayoutManager(context)
                    Log.d("vnvnvb", "" + data)


//data=purchasedGrocery.getData();
                }

                override fun onFailure(call: Call<ExpiryResponse?>, t: Throwable) {}
            })
        }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}