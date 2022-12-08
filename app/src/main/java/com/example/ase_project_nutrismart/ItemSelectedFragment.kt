package com.example.ase_project_nutrismart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ase_project_nutrismart.Adapter.SelectedGroceryAdapter
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel
import com.example.ase_project_nutrismart.Response.Grocery
import com.example.ase_project_nutrismart.Response.SelectedGrocery
import com.example.ase_project_nutrismart.Retrofit.APIClient.client
import com.example.ase_project_nutrismart.Retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class ItemSelectedFragment : Fragment() {
   lateinit var apiInterface: ApiInterface
    lateinit var  RvSelectedItems: RecyclerView
    lateinit var sendList: ArrayList<Grocery>
    lateinit var submit: Button
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
            val list: ArrayList<Grocery> = ArrayList<Grocery>()
            model.data = list
            model.purchasedDate = "2022-11-13"
            model.userEmail = "sd@yopmail.com"
            val send = apiInterface!!.sendSelectedGrocery(model)
            send!!.enqueue(object : Callback<SelectedGrocery?> {
                override fun onResponse(
                    call: Call<SelectedGrocery?>,
                    response: Response<SelectedGrocery?>
                ) {
                    Log.d("dkfkfg", "" + response.code())
                    sendList = response.body()!!.data!!
                    val adapter =
                        SelectedGroceryAdapter(this@ItemSelectedFragment,sendList)
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

                override fun onFailure(call: Call<SelectedGrocery?>, t: Throwable) {}
            })
        }
}