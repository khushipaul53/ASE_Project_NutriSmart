package com.example.ase_project_nutrismart.Adapter

import android.util.Log
import com.example.ase_project_nutrismart.ui.gallery.GroceryFragment
import com.example.ase_project_nutrismart.Response.Grocery
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import com.example.ase_project_nutrismart.R
import android.widget.TextView
import java.util.ArrayList

class PurchasedGroceryAdapter(
    var galleryFragment: GroceryFragment,
    var groceryList: ArrayList<Grocery>
) : RecyclerView.Adapter<PurchasedGroceryAdapter.ViewHolder>() {
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
            inflater.inflate(R.layout.purchased_grocery, parent, false)

        // Return a new holder instance
        return ViewHolder(contactView)
        //        return null;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Tv_itemName.text = groceryList[position].food
        holder.tv_proteins.text = groceryList[position].protein
        holder.tv_carbs.text = groceryList[position].carbs
        holder.tv_fibre.text = groceryList[position].fibers
        holder.tv_fats.text = groceryList[position].fat
        holder.cb_select.setOnClickListener {
            if (holder.cb_select.isChecked) {
                selectedItems.add(groceryList[position])
                Log.d("selected", "" + selectedItems.size)
                galleryFragment.sendList(selectedItems)
            } else if (!holder.cb_select.isChecked) {
//                selectedItems.remove(groceryList[position].food)
                Log.d("removed", "" + selectedItems.size)
                galleryFragment.sendList(selectedItems)
            }
        }


//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());
    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Tv_ReqQuantity: TextView? = null
        var Tv_itemName: TextView
        var tv_proteins: TextView
        var tv_carbs: TextView
        var tv_fats: TextView
        var tv_fibre: TextView
        var cb_select: CheckBox

        init {
            //            Tv_ReqQuantity=(TextView) itemView.findViewById(R.id.Tv_ReqQuantity);
            Tv_itemName = itemView.findViewById<View>(R.id.Tv_itemName) as TextView
            tv_proteins = itemView.findViewById<View>(R.id.Tv_Proteins) as TextView
            tv_carbs = itemView.findViewById<View>(R.id.Tv_Carbs) as TextView
            tv_fats = itemView.findViewById<View>(R.id.Tv_fats) as TextView
            tv_fibre = itemView.findViewById<View>(R.id.Tv_fibres) as TextView
            cb_select = itemView.findViewById(R.id.cb_select)
            //            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}