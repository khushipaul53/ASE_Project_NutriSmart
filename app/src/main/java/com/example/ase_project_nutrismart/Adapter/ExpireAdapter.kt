package com.example.ase_project_nutrismart.Adapter

import com.example.ase_project_nutrismart.ui.slideshow.ExpireFragment
import com.example.ase_project_nutrismart.Response.ExpireData
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.ase_project_nutrismart.R
import android.widget.TextView
import java.util.ArrayList

class ExpireAdapter(var galleryFragment: ExpireFragment, var groceryList: ArrayList<ExpireData>) :
    RecyclerView.Adapter<ExpireAdapter.ViewHolder>() {
    var selectedItems = ArrayList<ExpireData>()
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
        holder.tv_food.text = "Product:  Paneer"
        holder.tv_date.text = "Purchased Date:  2022-12-12"


//        holder.Tv_ReqQuantity.setText(groceryList.get(position).getMeasure());
    }

    override fun getItemCount(): Int {
        return 1
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