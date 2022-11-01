package com.example.ase_project_nutrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ase_project_nutrismart.Response.LoginResponse;
import com.example.ase_project_nutrismart.Retrofit.APIClient;
import com.example.ase_project_nutrismart.Retrofit.ApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
Button login;
EditText et_email,et_password;
    String Login="";
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        apiInterface = APIClient.getClient().create(ApiInterface.class);


login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(validateFields())
        {
            
            
               LoginApi();



        }

    }
});    }

    private void LoginApi() {
        String email=et_email.getText().toString();
                    String password=et_password.getText().toString();
      Map<String, String> data = new HashMap<>();
                    data.put("password", password);
                    data.put("usernameOrEmail", email);
                    Call<LoginResponse> call = apiInterface.login(data);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                            Log.d("dfkflk",response.code()+"");
//                            LoginResponse loginResponse = response.code;

                            Log.d("qwertyyyyy",""+response.code());
                            if(response.code()==500)
                            {
                                Toast.makeText(LoginActivity.this,"Bad Credentials",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(LoginActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();

                                Intent signup=new Intent(LoginActivity.this,HomeActvity.class);
                                startActivity(signup);

                            }
//                            Log.d("weidjf",""+loginResponse.getMessage());


                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.d("falireirfi","");


                        }
//
//
                    });
    }

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