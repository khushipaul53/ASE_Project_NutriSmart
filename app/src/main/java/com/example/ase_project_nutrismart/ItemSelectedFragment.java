package com.example.ase_project_nutrismart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.RecoverySystem;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ase_project_nutrismart.Adapter.PurchasedGroceryAdapter;
import com.example.ase_project_nutrismart.Adapter.SelectedGroceryAdapter;
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel;
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.Response.SelectedGrocery;
import com.example.ase_project_nutrismart.Retrofit.APIClient;
import com.example.ase_project_nutrismart.Retrofit.ApiInterface;
import com.example.ase_project_nutrismart.ui.gallery.GroceryFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ItemSelectedFragment extends Fragment {
    ApiInterface apiInterface;
RecyclerView RvSelectedItems;
    ArrayList<Grocery>sendList=new ArrayList<>();
    Button submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_item_selected, container, false);

        apiInterface = APIClient.getClient().create(ApiInterface.class);
        RvSelectedItems=view.findViewById(R.id.RvSelectedItems);
        submit=view.findViewById(R.id.submit);
        getPurchasedGroceryApi();

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        sendData();
    }
});
        // Inflate the layout for this fragment
        return view;
    }

    private void sendData() {

        SelectedGroceryModel model=new SelectedGroceryModel();
        model.setData(sendList);
        model.purchasedDate="2022-11-13";
        model.userEmail="sd@yopmail.com";
        Call<SelectedGrocery> send = apiInterface.sendSelectedGrocery(model);
        send.enqueue(new Callback<SelectedGrocery>() {
            @Override
            public void onResponse(Call<SelectedGrocery> call, Response<SelectedGrocery> response) {

                Log.d("dkfkfg",""+response.code());
                if(response.code()==201)
                {
                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_home_actvity);
                    navController.navigate(R.id.tracker);
                }
            }

            @Override
            public void onFailure(Call<SelectedGrocery> call, Throwable t) {

            }
        });


    }

    private void getPurchasedGroceryApi() {


        SelectedGroceryModel model=new SelectedGroceryModel();
        ArrayList <Grocery>list=new ArrayList();
        model.setData(list);
        model.purchasedDate="2022-11-13";
        model.userEmail="sd@yopmail.com";
        Call<SelectedGrocery> send = apiInterface.sendSelectedGrocery(model);
        send.enqueue(new Callback<SelectedGrocery>() {
            @Override
            public void onResponse(Call<SelectedGrocery> call, Response<SelectedGrocery> response) {

                Log.d("dkfkfg",""+response.code());
sendList=response.body().getData();
                SelectedGroceryAdapter adapter = new SelectedGroceryAdapter(ItemSelectedFragment.this,response.body().getData());
                // Attach the adapter to the recyclerview to populate items
                RvSelectedItems.setAdapter(adapter);
                // Set layout manager to position the items
                RvSelectedItems.setLayoutManager(new LinearLayoutManager(getContext()));

//                if(response.code()==201)
//                {
//                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_home_actvity);
//                    navController.navigate(R.id.itemSlected);
//                }
            }

            @Override
            public void onFailure(Call<SelectedGrocery> call, Throwable t) {

            }
        });

    }
}