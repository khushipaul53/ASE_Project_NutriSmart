package com.example.ase_project_nutrismart.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ase_project_nutrismart.Adapter.PurchasedGroceryAdapter;
import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.Response.LoginResponse;
import com.example.ase_project_nutrismart.Response.PurchasedGrocery;
import com.example.ase_project_nutrismart.Retrofit.APIClient;
import com.example.ase_project_nutrismart.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {
    ArrayList<Grocery> groceryList=new ArrayList<>();
    RecyclerView rvPurchased;
    ApiInterface apiInterface;
    PurchasedGrocery purchasedGrocery;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        rvPurchased = (RecyclerView) rootView.findViewById(R.id.rv_pruchased);
        apiInterface = APIClient.getClient().create(ApiInterface.class);

        getPurcharchedGroceryApi();










        return rootView;





    }

    private void getPurcharchedGroceryApi() {

        Call<PurchasedGrocery> call = apiInterface.groceryList();
       call.enqueue(new Callback<PurchasedGrocery>() {
           @Override
           public void onResponse(Call<PurchasedGrocery> call, Response<PurchasedGrocery> response) {
//                purchasedGrocery=response.body().getData();
                ArrayList<Grocery> data=new ArrayList<>();
                  groceryList=response.body().data;
                Log.d("dfkgg","fk"+data.size());

               PurchasedGroceryAdapter adapter = new PurchasedGroceryAdapter(GalleryFragment.this,groceryList);
               // Attach the adapter to the recyclerview to populate items
               rvPurchased.setAdapter(adapter);
               // Set layout manager to position the items
               rvPurchased.setLayoutManager(new LinearLayoutManager(getContext()));
//data=purchasedGrocery.getData();
//               for(int i=0;i<data.size();i++)
//               {
//                   groceryList=response.body().getData();

//               }
           }

           @Override
           public void onFailure(Call<PurchasedGrocery> call, Throwable t) {

           }
       });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}