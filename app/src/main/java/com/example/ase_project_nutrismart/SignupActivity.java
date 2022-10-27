package com.example.ase_project_nutrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {
EditText et_dob,et_name,et_email,et_height,et_weight,et_password;
Button btn_create_new_user;
Spinner sp_actvity;
    final Calendar myCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et_dob=findViewById(R.id.et_dob);
        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);
        et_height=findViewById(R.id.et_height);
        et_weight=findViewById(R.id.et_weight);
        et_password=findViewById(R.id.et_password);
        sp_actvity=findViewById(R.id.sp_actvity);

        btn_create_new_user=findViewById(R.id.btn_create_new_user);
        btn_create_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {
                    Intent signup=new Intent(SignupActivity.this,HomeActvity.class);
                    startActivity(signup);
                }

            }
        });
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        et_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SignupActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                

            }
        });

        String[] arraySpinner = new String[] {
                "Choose your activity level", "Sedentary - little or no exercise",
                "Lightly active - exercise sports 1-3 times per week",
                "Moderately active - exercise sports 3-5 times per week",
                "Very active - hard exercise/sports 6-7 times per week",
                "Extra active - very hard exercise/sports or physical"
        };
        Spinner s = (Spinner) findViewById(R.id.sp_actvity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
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


}