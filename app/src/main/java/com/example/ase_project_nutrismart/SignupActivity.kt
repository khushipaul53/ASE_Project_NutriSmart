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
import com.example.ase_project_nutrismart.Response.LoginResponse
import com.example.ase_project_nutrismart.HomeActvity
import com.example.ase_project_nutrismart.SignupActivity
import com.example.ase_project_nutrismart.LoginActivity
import com.example.ase_project_nutrismart.ProfileFragment
import android.app.DatePickerDialog.OnDateSetListener
import android.app.DatePickerDialog
import com.example.ase_project_nutrismart.Response.BmiResponse
import kotlin.Throws
import com.example.ase_project_nutrismart.Response.SignupResponse
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.*
import com.example.ase_project_nutrismart.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {
    var et_dob: EditText? = null
    var et_name: EditText? = null
    var et_email: EditText? = null
    var et_height: EditText? = null
    var et_weight: EditText? = null
    var et_password: EditText? = null
    var btn_create_new_user: Button? = null
    var sp_actvity: Spinner? = null
    var gender = ""
    var bundle = Bundle()
    var flag = 0
    var list_email: List<String> = ArrayList()
    var rb_female: RadioButton? = null
    var rbMale: RadioButton? = null
    val myCalendar = Calendar.getInstance()
    var apiInterface: ApiInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        et_dob = findViewById(R.id.et_dob)
        et_name = findViewById(R.id.et_name)
        et_email = findViewById(R.id.et_email)
        et_height = findViewById(R.id.et_height)
        et_weight = findViewById(R.id.et_weight)
        et_password = findViewById(R.id.et_password)
        sp_actvity = findViewById(R.id.sp_actvity)
        apiInterface = client!!.create(ApiInterface::class.java)
        rb_female = findViewById(R.id.rb_female)
        rbMale = findViewById(R.id.rb_male)
        //        userlistApi();
        btn_create_new_user = findViewById(R.id.btn_new_user)
        btn_create_new_user.setOnClickListener(View.OnClickListener {
            if (validate()) {
                val weight = et_weight.getText().toString().toInt()
                val name = et_name.getText().toString()
                val height = et_height.getText().toString().toInt()
                val BMI = weight / (height * height)
                Log.d("djf", "" + BMI)
                val b = Bundle()
                b.putInt("BMI", BMI)
            }
            bmiApi()
        } // set Fragmentclass Arguments
            //                HomeFragment fragobj = new HomeFragment();
            //                fragobj.setArguments(b);
        )
        val date = OnDateSetListener { view, year, month, day ->
            myCalendar[Calendar.YEAR] = year
            myCalendar[Calendar.MONTH] = month
            myCalendar[Calendar.DAY_OF_MONTH] = day
            updateLabel()
        }
        et_dob.setOnClickListener(View.OnClickListener { //            hideKeyboard(getActivi);
            DatePickerDialog(
                this@SignupActivity,
                date,
                myCalendar[Calendar.YEAR],
                myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH]
            ).show()
        })
        val arraySpinner = arrayOf(
            "Choose your activity level",
            "Sedentary",
            "Lightly active",
            "Moderately active",
            "Very active",
            "Extra active"
        )
        val s = findViewById<View>(R.id.sp_actvity) as Spinner
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, arraySpinner
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        s.adapter = adapter
    }

    private fun bmiApi() {
        gender = if (rbMale!!.isChecked) {
            "Male"
        } else {
            "Female"
        }
        val dob = et_dob!!.text.toString()
        //        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//        Date birthDate = sdf.parse(dob);
//        sdf.applyPattern("dd/mm/yyyy");
//        String new_dob=sdf.format(birthDate);
//Log.d("dkfd",""+new_dob);
        val Age = getAge(dob)
        val currentAge = Integer.toString(Age)
        Log.d("dkfd", "" + Age)
        val bmi = apiInterface!!.bmi(
            et_weight!!.text.toString(),
            et_height!!.text.toString(),
            currentAge,
            gender
        )
        bmi!!.enqueue(object : Callback<BmiResponse> {
            override fun onResponse(call: Call<BmiResponse>, response: Response<BmiResponse>) {
                val bmi = response.body().data!!.bMI
                val proteinNeeded = response.body().data!!.proteinNeeded
                val carbsNeeded = response.body().data!!.carbsNeeded
                val fatsNeeded = response.body().data!!.fatsNeeded
                val calorie = response.body().data!!.calorie
                bundle.putString("bmi", java.lang.Double.toString(bmi))
                bundle.putString("proteinNeeded", java.lang.Double.toString(proteinNeeded))
                bundle.putString("carbsNeeded", java.lang.Double.toString(carbsNeeded))
                bundle.putString("fatsNeeded", java.lang.Double.toString(fatsNeeded))
                bundle.putString("calorie", java.lang.Double.toString(calorie))
                try {
                    signupApi()
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
                Log.d("dkksd", "" + response.code())
            }

            override fun onFailure(call: Call<BmiResponse>, t: Throwable) {}
        })
    }

    //    private void userlistApi() {
    //        Call<List<SignupListResponse>> list = apiInterface.userList();
    //        list.enqueue(new Callback<List<SignupListResponse>>() {
    //            @Override
    //            public void onResponse(Call<List<SignupListResponse>> call, Response<List<SignupListResponse>> response) {
    //                Log.d("dfkflk",response.code()+"");
    //                List<SignupListResponse> list = response.body();
    //                Log.d("qwertyyyyy",""+response.message());
    //                for (int i=0;i<list.size();i++)
    //                {
    //                    list_email.add(list.get(i).getEmail());
    //                }
    //
    //            }
    //
    //            @Override
    //            public void onFailure(Call<List<SignupListResponse>> call, Throwable t) {
    //
    //            }
    //        });
    //    }
    @Throws(ParseException::class)
    private fun signupApi() {
        val password = et_password!!.text.toString()
        val email = et_email!!.text.toString()
        val activity_level = sp_actvity!!.selectedItem.toString()
        gender = if (rbMale!!.isChecked) {
            "Male"
        } else {
            "Female"
        }
        val height = et_height!!.text.toString()
        val weight = et_weight!!.text.toString()
        val name = et_name!!.text.toString()
        val username = et_name!!.text.toString()
        val dob = et_dob!!.text.toString()

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//        Date birthDate = sdf.parse(dob);
//        sdf.applyPattern("dd/mm/yyyy");
//        String new_dob=sdf.format(birthDate);
//Log.d("dkfd",""+new_dob);
        val Age = getAge(dob)
        val currentAge = Integer.toString(Age)
        Log.d("dkfd", "" + Age)
        val data: MutableMap<String?, String?> = HashMap()
        data["activitylevel"] = activity_level
        data["age"] = currentAge
        data["email"] = email
        data["gender"] = gender
        data["height"] = height
        data["name"] = name
        data["password"] = password
        data["username"] = username
        data["weight"] = weight
        val signup = apiInterface!!.signup(data)
        signup!!.enqueue(object : Callback<SignupResponse> {
            override fun onResponse(
                call: Call<SignupResponse>,
                response: Response<SignupResponse>
            ) {
                val signupResponse = response.body()
                //                Log.d("asdfgh",  ""+ signupResponse.getMessage());

////                signupResponse.getMessage()
                if (response.code() == 400) {
                    Toast.makeText(
                        this@SignupActivity,
                        "Email is already taken!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (signupResponse.message.equals(
                        "User registered successfully",
                        ignoreCase = true
                    )
                ) {
                    Toast.makeText(
                        this@SignupActivity,
                        "User is logged in successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    //                    HomeFragment fragobj = new HomeFragment();
//                    fragobj.setArguments(bundle);
//
                    val signup = Intent(this@SignupActivity, HomeActvity::class.java)
                    //                    bundle.putBoolean("isSingup",true);
                    startActivity(signup)
                }

//                Log.d("qwertyyyyy", "" + response.message());
//                Log.d("bodyyyy", "" + response.body());
//                Log.d("string", "" + response.toString());
//                Log.d("errorBody", "" + response.isSuccessful());


//
//                  if (response.code() == 400) {
//                    Toast.makeText(SignupActivity.this, "Email is already taken!", Toast.LENGTH_SHORT).show();
//
//                }
//                  else{
//
//                      Toast.makeText(SignupActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                      Intent signup = new Intent(SignupActivity.this, HomeActvity.class);
//                      startActivity(signup);
//                  }
            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {}
        })
    }

    private fun getAge(birthdate: String): Int {
        var date: Date? = null
        val sdf = SimpleDateFormat("dd/MM/yy")
        try {
            date = sdf.parse(birthdate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (date == null) return 0
        val dob = Calendar.getInstance()
        val today = Calendar.getInstance()
        dob.time = date
        val year = dob[Calendar.YEAR]
        val month = dob[Calendar.MONTH]
        val day = dob[Calendar.DAY_OF_MONTH]
        dob[year, month + 1] = day
        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }
        return age
    }

    private fun validate(): Boolean {
        if (et_name!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            return false
        } else if (et_email!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show()
            return false
        } else if (et_dob!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your Dob", Toast.LENGTH_SHORT).show()
            return false
        } else if (et_height!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your height", Toast.LENGTH_SHORT).show()
            return false
        } else if (et_weight!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your weight", Toast.LENGTH_SHORT).show()
            return false
        } else if (sp_actvity!!.selectedItem.toString() == "Choose your activity level") {
            Toast.makeText(this, "Please select your activity level", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun updateLabel() {
        val myFormat = "MM/dd/yy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        et_dob!!.setText(dateFormat.format(myCalendar.time))
    } //    public static void hideKeyboard(Activity activity) {
    //        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    //        //Find the currently focused view, so we can grab the correct window token from it.
    //        View view = activity.getCurrentFocus();
    //        //If no view currently has focus, create a new one, just so we can grab a window token from it
    //        if (view == null) {
    //            view = new View(activity);
    //        }
    //        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    //    }
}