package com.example.ase_project_nutrismart.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ase_project_nutrismart.Adapter.ExpireAdapter;
import com.example.ase_project_nutrismart.Adapter.PurchasedGroceryAdapter;
import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.Response.ExpireData;
import com.example.ase_project_nutrismart.Response.ExpiryResponse;
import com.example.ase_project_nutrismart.Response.PurchasedGrocery;
import com.example.ase_project_nutrismart.Retrofit.APIClient;
import com.example.ase_project_nutrismart.Retrofit.ApiInterface;
import com.example.ase_project_nutrismart.ui.gallery.GroceryFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpireFragment extends Fragment {
    ApiInterface apiInterface;
RecyclerView  rv_expire;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expire, container, false);
        apiInterface = APIClient.getClient().create(ApiInterface.class);
        rv_expire=rootView.findViewById(R.id.rv_expire);
        getExpireData();

        return rootView;
    }
    ArrayList<ExpireData>data=new ArrayList<>();

    private void getExpireData() {
        ExpireAdapter adapter = new ExpireAdapter(ExpireFragment.this,data);
        // Attach the adapter to the recyclerview to populate items
        rv_expire.setAdapter(adapter);
        // Set layout manager to position the items
        rv_expire.setLayoutManager(new LinearLayoutManager(getContext()));
        Call<ExpiryResponse> call = apiInterface.getExpiryList("test2@yopmail.com");
        call.enqueue(new Callback<ExpiryResponse>() {
            @Override
            public void onResponse(Call<ExpiryResponse> call, Response<ExpiryResponse> response) {

                ArrayList<ExpireData>data=response.body().getData();
                Log.d("vnvnvb",""+data);


//data=purchasedGrocery.getData();
            }

            @Override
            public void onFailure(Call<ExpiryResponse> call, Throwable t) {

            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}