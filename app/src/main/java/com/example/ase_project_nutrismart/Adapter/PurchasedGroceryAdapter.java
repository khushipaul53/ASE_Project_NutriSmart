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
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.ui.gallery.GroceryFragment;

import java.util.ArrayList;

public class PurchasedGroceryAdapter extends RecyclerView.Adapter<PurchasedGroceryAdapter.ViewHolder> {

    ArrayList<Grocery> groceryList;
    private ViewHolder holder;
    ArrayList<Grocery> selectedItems=new ArrayList<>();
    GroceryFragment galleryFragment;

    public PurchasedGroceryAdapter(GroceryFragment galleryFragment, ArrayList<Grocery> groceryList) {
        this.groceryList=groceryList;
        this.galleryFragment=galleryFragment;
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
        holder.tv_proteins.setText(groceryList.get(position).getProtein());
        holder.tv_carbs.setText(groceryList.get(position).getCarbs());
        holder.tv_fibre.setText(groceryList.get(position).getFibers());
        holder.tv_fats.setText(groceryList.get(position).getFat());

        holder.cb_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.cb_select.isChecked())
                {
                    selectedItems.add(groceryList.get(position));
                    Log.d("selected",""+selectedItems.size());
                    galleryFragment.sendList(selectedItems);
                }
                else if (!holder.cb_select.isChecked())
                {
                    selectedItems.remove(groceryList.get(position).getFood());
                    Log.d("removed",""+selectedItems.size());
                    galleryFragment.sendList(selectedItems);



                }
            }

        });



//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Tv_ReqQuantity;
        public TextView Tv_itemName;
        public TextView tv_proteins;
        public TextView tv_carbs;
        public TextView tv_fats;
        public TextView tv_fibre;
        public CheckBox cb_select;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);
//            Tv_ReqQuantity=(TextView) itemView.findViewById(R.id.Tv_ReqQuantity);
            Tv_itemName=(TextView) itemView.findViewById(R.id.Tv_itemName);
            tv_proteins=(TextView) itemView.findViewById(R.id.Tv_Proteins);
            tv_carbs=(TextView) itemView.findViewById(R.id.Tv_Carbs);
            tv_fats=(TextView) itemView.findViewById(R.id.Tv_fats);
            tv_fibre=(TextView) itemView.findViewById(R.id.Tv_fibres);
            cb_select=itemView.findViewById(R.id.cb_select);
        //            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
