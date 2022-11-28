package com.example.ase_project_nutrismart.ui

import android.os.Bundle
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.ase_project_nutrismart.R
import com.example.ase_project_nutrismart.ui.MyDialogFragment

/**
 * A simple [Fragment] subclass.
 * Use the [MyDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyDialogFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val builder = AlertDialog.Builder(
            context!!
        )
        builder.setTitle("Confirm")
        builder.setMessage("Are you sure?")
        builder.setPositiveButton("YES") { dialog, which -> // Do nothing but close the dialog
            dialog.dismiss()
        }
        builder.setNegativeButton("NO") { dialog, which -> // Do nothing
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): MyDialogFragment {
            return MyDialogFragment()
        }
    }
}