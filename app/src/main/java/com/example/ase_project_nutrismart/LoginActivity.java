package com.example.ase_project_nutrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button login;
EditText et_email,et_password;
    String Login="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);


login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(validateFields())
        {

               Intent signup=new Intent(LoginActivity.this,HomeActvity.class);


               startActivity(signup);



        }

    }
});    }

    private boolean validateFields() {
        if(et_email.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(et_password.getText().toString().isEmpty())

        {
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
         return false;
        }
        return true;
    }
}