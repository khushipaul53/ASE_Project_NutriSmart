package com.example.ase_project_nutrismart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ase_project_nutrismart.Response.BmiResponse;
import com.example.ase_project_nutrismart.Response.LoginResponse;
import com.example.ase_project_nutrismart.Response.SignupListResponse;
import com.example.ase_project_nutrismart.Response.SignupResponse;
import com.example.ase_project_nutrismart.Retrofit.APIClient;
import com.example.ase_project_nutrismart.Retrofit.ApiInterface;
import com.example.ase_project_nutrismart.ui.home.HomeFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    EditText et_dob, et_name, et_email, et_height, et_weight, et_password;
    Button btn_create_new_user;
    Spinner sp_actvity;
    String gender = "";
    Bundle bundle=new Bundle();

    int flag = 0;
    List<String> list_email = new ArrayList<>();
    RadioButton rb_female, rbMale;
    final Calendar myCalendar = Calendar.getInstance();
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et_dob = findViewById(R.id.et_dob);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        et_password = findViewById(R.id.et_password);
        sp_actvity = findViewById(R.id.sp_actvity);
        apiInterface = APIClient.getClient().create(ApiInterface.class);
        rb_female = findViewById(R.id.rb_female);
        rbMale = findViewById(R.id.rb_male);
//        userlistApi();

        btn_create_new_user = findViewById(R.id.btn_new_user);

        btn_create_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {

                    int weight = Integer.parseInt(et_weight.getText().toString());
                    String name = et_name.getText().toString();
                    int height = Integer.parseInt(et_height.getText().toString());
                    int BMI = (weight) / ((height) * (height));
                    Log.d("djf", "" + BMI);
                    Bundle b = new Bundle();
                    b.putInt("BMI", BMI);

                }

                        bmiApi();



            }


// set Fragmentclass Arguments
//                HomeFragment fragobj = new HomeFragment();
//                fragobj.setArguments(b);


        });


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        }
    };
        et_dob.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
//            hideKeyboard(getActivi);
        new DatePickerDialog(SignupActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();


    }
    });

    String[] arraySpinner = new String[]{
            "Choose your activity level",
            "Sedentary",
            "Lightly active",
            "Moderately active",
            "Very active",
            "Extra active"
    };
    Spinner s = (Spinner) findViewById(R.id.sp_actvity);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

}

    private void bmiApi() {
        if(rbMale.isChecked())
        {
            gender="Male";
        }
        else{
            gender="Female";
        }

        String dob=et_dob.getText().toString();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//        Date birthDate = sdf.parse(dob);
//        sdf.applyPattern("dd/mm/yyyy");
//        String new_dob=sdf.format(birthDate);
//Log.d("dkfd",""+new_dob);
        int Age=getAge(dob);
        String currentAge=Integer.toString(Age);
        Log.d("dkfd",""+Age);
        Call<BmiResponse> bmi = apiInterface.bmi(et_weight.getText().toString(),et_height.getText().toString(),currentAge,gender);
   bmi.enqueue(new Callback<BmiResponse>() {
       @Override
       public void onResponse(Call<BmiResponse> call, Response<BmiResponse> response) {

           Double bmi=response.body().data.bMI;
           Double proteinNeeded=response.body().data.proteinNeeded;
           Double carbsNeeded=response.body().data.carbsNeeded;
           Double fatsNeeded=response.body().data.fatsNeeded;
           Double calorie=response.body().data.calorie;


bundle.putString("bmi",Double.toString(bmi));
           bundle.putString("proteinNeeded",Double.toString(proteinNeeded));
           bundle.putString("carbsNeeded",Double.toString(carbsNeeded));
           bundle.putString("fatsNeeded",Double.toString(fatsNeeded));
           bundle.putString("calorie",Double.toString(calorie));


           try {
               signupApi();
           } catch (ParseException e) {
               e.printStackTrace();
           }

           Log.d("dkksd",""+response.code());





       }

       @Override
       public void onFailure(Call<BmiResponse> call, Throwable t) {

       }
   });

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

    private void signupApi() throws ParseException {
        String password=et_password.getText().toString();
        String email=et_email.getText().toString();
        String activity_level=sp_actvity.getSelectedItem().toString();

        if(rbMale.isChecked())
        {
            gender="Male";
        }
        else{
            gender="Female";
        }
        String height=et_height.getText().toString();
        String weight=et_weight.getText().toString();
        String name=et_name.getText().toString();
        String username=et_name.getText().toString();
        String dob=et_dob.getText().toString();

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//        Date birthDate = sdf.parse(dob);
//        sdf.applyPattern("dd/mm/yyyy");
//        String new_dob=sdf.format(birthDate);
//Log.d("dkfd",""+new_dob);
int Age=getAge(dob);
String currentAge=Integer.toString(Age);
Log.d("dkfd",""+Age);



        Map<String, String> data = new HashMap<>();
        data.put("activitylevel", activity_level);
        data.put("age", currentAge);
        data.put("email", email);
        data.put("gender", gender);
        data.put("height", height);
        data.put("name", name);
        data.put("password", password);
        data.put("username", username);
        data.put("weight", weight);

        Call<SignupResponse> signup = apiInterface.signup(data);
        signup.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                SignupResponse signupResponse = response.body();
//                Log.d("asdfgh",  ""+ signupResponse.getMessage());

////                signupResponse.getMessage()
                if(response.code()==400)
                {
                    Toast.makeText(SignupActivity.this,"Email is already taken!",Toast.LENGTH_SHORT).show();

                }
                else if(signupResponse.getMessage().equalsIgnoreCase("User registered successfully")){
                    Toast.makeText(SignupActivity.this,"User is logged in successfully",Toast.LENGTH_SHORT).show();
//                    HomeFragment fragobj = new HomeFragment();
//                    fragobj.setArguments(bundle);
//
                    Intent signup = new Intent(SignupActivity.this, HomeActvity.class);
//                    bundle.putBoolean("isSingup",true);
                      startActivity(signup);

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
            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {

            }
        });

    }

    private int getAge(String birthdate) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            date = sdf.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(date == null) return 0;

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.setTime(date);

        int year = dob.get(Calendar.YEAR);
        int month = dob.get(Calendar.MONTH);
        int day = dob.get(Calendar.DAY_OF_MONTH);

        dob.set(year, month+1, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }



        return age;
    }

    private boolean validate() {

        if(et_name.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show();
           return false;
        }
        else if(et_email.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter your Email",Toast.LENGTH_SHORT).show();

            return false;

        }

        else if(et_dob.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter your Dob",Toast.LENGTH_SHORT).show();

            return false;

        }
        else if(et_height.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter your height",Toast.LENGTH_SHORT).show();

            return false;

        }
        else if(et_weight.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter your weight",Toast.LENGTH_SHORT).show();

            return false;

        }
        else if (sp_actvity.getSelectedItem().toString().equals("Choose your activity level"))
        {
            Toast.makeText(this,"Please select your activity level",Toast.LENGTH_SHORT).show();

            return false;

        }

        return true;
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        et_dob.setText(dateFormat.format(myCalendar.getTime()));
    }

//    public static void hideKeyboard(Activity activity) {
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