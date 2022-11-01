package com.example.ase_project_nutrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ase_project_nutrismart.Response.LoginResponse;
import com.example.ase_project_nutrismart.Retrofit.APIClient;
import com.example.ase_project_nutrismart.Retrofit.ApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    Button btn_create_new_user,btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_create_new_user=findViewById(R.id.btn_create_new_user);
        btn_login=findViewById(R.id.btn_login);
        Bundle b=new Bundle();
        b.getString("isLogin");

        apiInterface = APIClient.getClient().create(ApiInterface.class);
        btn_create_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(signup,b);



            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//

                Intent login=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(login,b);

            }
        });
    }
}