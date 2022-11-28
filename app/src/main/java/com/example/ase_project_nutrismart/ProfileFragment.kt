package com.example.ase_project_nutrismart

import androidx.navigation.ui.AppBarConfiguration.Builder.setOpenableLayout
import androidx.navigation.ui.AppBarConfiguration.Builder.build
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.NavController.navigate
import androidx.navigation.ui.NavigationUI.navigateUp
import com.example.ase_project_nutrismart.Retrofit.APIClient.client
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel.data
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.sendSelectedGrocery
import com.example.ase_project_nutrismart.Response.SelectedGrocery.data
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.login
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.bmi
import com.example.ase_project_nutrismart.Retrofit.ApiInterface.signup
import com.example.ase_project_nutrismart.Response.SignupResponse.message
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.example.ase_project_nutrismart.R
import androidx.navigation.NavController
import androidx.core.view.GravityCompat
import android.content.DialogInterface
import android.content.Intent
import com.example.ase_project_nutrismart.SplashActivity
import com.example.ase_project_nutrismart.Retrofit.ApiInterface
import androidx.recyclerview.widget.RecyclerView
import com.example.ase_project_nutrismart.Response.Grocery
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ase_project_nutrismart.Retrofit.APIClient
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel
import com.example.ase_project_nutrismart.Response.SelectedGrocery
import com.example.ase_project_nutrismart.Adapter.SelectedGroceryAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.EditText
import com.example.ase_project_nutrismart.Response.LoginResponse
import android.widget.Toast
import com.example.ase_project_nutrismart.HomeActvity
import com.example.ase_project_nutrismart.SignupActivity
import com.example.ase_project_nutrismart.LoginActivity
import com.example.ase_project_nutrismart.ProfileFragment
import android.app.DatePickerDialog.OnDateSetListener
import android.app.DatePickerDialog
import android.widget.ArrayAdapter
import com.example.ase_project_nutrismart.Response.BmiResponse
import kotlin.Throws
import com.example.ase_project_nutrismart.Response.SignupResponse
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ase_project_nutrismart.MainActivity

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}