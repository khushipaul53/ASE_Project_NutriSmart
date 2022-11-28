package com.example.ase_project_nutrismart.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ase_project_nutrismart.ItemSelectedFragment;
import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.ui.gallery.GroceryFragment;

import java.util.ArrayList;

public class SelectedGroceryAdapter  extends RecyclerView.Adapter<SelectedGroceryAdapter.ViewHolder>{
    ArrayList<Grocery> groceryList;
    private SelectedGroceryAdapter.ViewHolder holder;
    ArrayList<Grocery> selectedItems=new ArrayList<>();
    ItemSelectedFragment itemSelectedFragment;

    public SelectedGroceryAdapter(ItemSelectedFragment galleryFragment, ArrayList<Grocery> groceryList) {
        this.groceryList=groceryList;
        this.itemSelectedFragment=galleryFragment;
    }

    @NonNull
    @Override
    public SelectedGroceryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.selected_grocery_items, parent, false);

        // Return a new holder instance
        SelectedGroceryAdapter.ViewHolder viewHolder = new SelectedGroceryAdapter.ViewHolder(contactView);


        return viewHolder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedGroceryAdapter.ViewHolder holder, int position) {
//        holder.Tv_itemName.setText(groceryList.get(position).getFood());
//        holder.tv_proteins.setText(groceryList.get(position).getProtein());
//        holder.tv_carbs.setText(groceryList.get(position).getCarbs());
//        holder.tv_fibre.setText(groceryList.get(position).getFibers());
//        holder.tv_fats.setText(groceryList.get(position).getFat());

        holder.tvProduct.setText("Product: "+groceryList.get(position).getFood());

//



//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());

    }


    @Override
    public int getItemCount() {
        return groceryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProduct;
        public EditText tvQuantity;
        public EditText tvExpiryDate;


        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            tvProduct=(TextView) itemView.findViewById(R.id.tvProduct);
            tvQuantity=(EditText) itemView.findViewById(R.id.etQuantity);
            tvExpiryDate=(EditText) itemView.findViewById(R.id.etExpiryDate);

            //            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
    
}
