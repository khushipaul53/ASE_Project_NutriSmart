package com.example.ase_project_nutrismart.Retrofit;

import com.example.ase_project_nutrismart.Response.LoginResponse;
import com.example.ase_project_nutrismart.Response.SignupListResponse;
import com.example.ase_project_nutrismart.Response.SignupResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @POST("/api/v1/auth/signin")
    Call<LoginResponse> login(@Body Map<String, String> param);

    @POST("/api/v1/auth/signup")
    Call<SignupResponse>signup(@Body Map<String,String> param);

    @GET("/api/v1/auth/list")
    Call<List<SignupListResponse>>userList();

}
