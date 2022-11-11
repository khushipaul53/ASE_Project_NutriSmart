package com.example.ase_project_nutrismart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.Response.PurchasedGrocery;
import com.example.ase_project_nutrismart.ui.gallery.GalleryFragment;

import java.util.ArrayList;

public class PurchasedGroceryAdapter extends RecyclerView.Adapter<PurchasedGroceryAdapter.ViewHolder> {

    ArrayList<Grocery> groceryList;
    public PurchasedGroceryAdapter(GalleryFragment galleryFragment, ArrayList<Grocery> groceryList) {
        this.groceryList=groceryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.purchased_grocery, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);


        return viewHolder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PurchasedGroceryAdapter.ViewHolder holder, int position) {
        holder.Tv_itemName.setText(groceryList.get(position).getFood());
//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Tv_ReqQuantity;
        public TextView Tv_itemName;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
//            Tv_ReqQuantity=(TextView) itemView.findViewById(R.id.Tv_ReqQuantity);
            Tv_itemName=(TextView) itemView.findViewById(R.id.Tv_itemName);
//            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
