package com.example.ase_project_nutrismart.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.Response.ExpireData;
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.ui.gallery.GroceryFragment;
import com.example.ase_project_nutrismart.ui.slideshow.ExpireFragment;

import java.util.ArrayList;

public class ExpireAdapter extends RecyclerView.Adapter<ExpireAdapter.ViewHolder>{


    ArrayList<ExpireData> groceryList;
    ArrayList<ExpireData> selectedItems=new ArrayList<>();
    ExpireFragment galleryFragment;

    public ExpireAdapter(ExpireFragment galleryFragment, ArrayList<ExpireData> groceryList) {
        this.groceryList=groceryList;
        this.galleryFragment=galleryFragment;
    }

    @NonNull
    @Override
    public ExpireAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.expire_item_list, parent, false);

        // Return a new holder instance
        ExpireAdapter.ViewHolder viewHolder = new ExpireAdapter.ViewHolder(contactView);


        return viewHolder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpireAdapter.ViewHolder holder, int position) {
        holder.tv_food.setText("Product:  Paneer");
        holder.tv_date.setText("Purchased Date:  2022-12-12");





//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());

    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_food;
        public TextView tv_date;


        public ViewHolder(@NonNull View itemView) {


            super(itemView);
//            Tv_ReqQuantity=(TextView) itemView.findViewById(R.id.Tv_ReqQuantity);
            tv_food=(TextView) itemView.findViewById(R.id.tv_expireDate);
            tv_date=(TextView) itemView.findViewById(R.id.tv_expireItem);

            //            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
