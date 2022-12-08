package com.example.ase_project_nutrismart.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ase_project_nutrismart.R
import com.example.ase_project_nutrismart.Response.ExpireData
import com.example.ase_project_nutrismart.ui.slideshow.ExpireFragment

class ExpireAdapter(var galleryFragment: ExpireFragment, var groceryList: ArrayList<ExpireData>) :
    RecyclerView.Adapter<ExpireAdapter.ViewHolder>() {
    var selectedItems =groceryList
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView =
            inflater.inflate(R.layout.expire_item_list, parent, false)

        // Return a new holder instance
        return ViewHolder(contactView)
        //        return null;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_food.text = "Product:  "+selectedItems.get(position).food
        holder.tv_date.text = "Expire Date:  "+selectedItems.get(position).expiryDate


//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());
    }

    override fun getItemCount(): Int {
        return selectedItems!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_food: TextView
        var tv_date: TextView

        init {
            //            Tv_ReqQuantity=(TextView) itemView.findViewById(R.id.Tv_ReqQuantity);
            tv_food = itemView.findViewById<View>(R.id.tv_expireDate) as TextView
            tv_date = itemView.findViewById<View>(R.id.tv_expireItem) as TextView

            //            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}