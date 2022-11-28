package com.example.ase_project_nutrismart.Retrofit;

import com.example.ase_project_nutrismart.Model.SelectedGroceryModel;
import com.example.ase_project_nutrismart.Response.BmiResponse;
import com.example.ase_project_nutrismart.Response.ExpiryResponse;
import com.example.ase_project_nutrismart.Response.Grocery;
import com.example.ase_project_nutrismart.Response.LoginResponse;
import com.example.ase_project_nutrismart.Response.PurchasedGrocery;
import com.example.ase_project_nutrismart.Response.SelectedGrocery;
import com.example.ase_project_nutrismart.Response.SignupListResponse;
import com.example.ase_project_nutrismart.Response.SignupResponse;
import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @POST("/api/v1/auth/signin")
    Call<LoginResponse> login(@Body Map<String, String> param);

    @POST("/api/v1/auth/signup")
    Call<SignupResponse>signup(@Body Map<String,String> param);

    @GET("/api/v1/application/bmiCalc/{mass}/{height}/{age}/{gender}")
            Call<BmiResponse>bmi(@Path("mass")String mass, @Path("height")String height,  @Path("age")String age,  @Path("gender")String gender);


    @GET("/api/v1/auth/list")
    Call<List<SignupListResponse>>userList();


    @GET("api/v1/master/getFoods")
    Call<PurchasedGrocery>groceryList();


    @POST("/api/v1/application/selectedgrocery")
    Call<SelectedGrocery>sendSelectedGrocery(@Body SelectedGroceryModel model);

    @GET("api/v1/application/getExpiredItems")
    Call<ExpiryResponse>getExpiryList(@Query("userEmail")String userEmail);

}
