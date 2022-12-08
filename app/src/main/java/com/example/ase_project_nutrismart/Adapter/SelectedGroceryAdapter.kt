package com.example.ase_project_nutrismart.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ase_project_nutrismart.ItemSelectedFragment
import com.example.ase_project_nutrismart.R
import com.example.ase_project_nutrismart.Response.Grocery

class SelectedGroceryAdapter(
    var itemSelectedFragment: ItemSelectedFragment,
    var groceryList: ArrayList<Grocery>?
) : RecyclerView.Adapter<SelectedGroceryAdapter.ViewHolder>() {
    private val holder: ViewHolder? = null
    var selectedItems = ArrayList<Grocery>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView =
            inflater.inflate(R.layout.selected_grocery_items, parent, false)

        // Return a new holder instance
        return ViewHolder(contactView)
        //        return null;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.Tv_itemName.setText(groceryList.get(position).getFood());
//        holder.tv_proteins.setText(groceryList.get(position).getProtein());
//        holder.tv_carbs.setText(groceryList.get(position).getCarbs());
//        holder.tv_fibre.setText(groceryList.get(position).getFibers());
//        holder.tv_fats.setText(groceryList.get(position).getFat());
        holder.tvProduct.text = "Product: " + groceryList!![position].food

//


//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());
    }

    override fun getItemCount(): Int {
        return groceryList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvProduct: TextView
        var tvQuantity: EditText
        var tvExpiryDate: EditText

        init {
            tvProduct = itemView.findViewById<View>(R.id.tvProduct) as TextView
            tvQuantity = itemView.findViewById<View>(R.id.etQuantity) as EditText
            tvExpiryDate = itemView.findViewById<View>(R.id.etExpiryDate) as EditText

            //            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}