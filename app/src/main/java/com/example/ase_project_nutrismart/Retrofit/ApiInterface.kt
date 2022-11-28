package com.example.ase_project_nutrismart.Retrofit

import okhttp3.logging.HttpLoggingInterceptor.setLevel
import okhttp3.OkHttpClient.Builder.addInterceptor
import okhttp3.OkHttpClient.Builder.build
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import com.example.ase_project_nutrismart.Retrofit.APIClient
import retrofit2.converter.gson.GsonConverterFactory
import com.example.ase_project_nutrismart.Response.LoginResponse
import com.example.ase_project_nutrismart.Response.SignupResponse
import com.example.ase_project_nutrismart.Response.BmiResponse
import com.example.ase_project_nutrismart.Response.SignupListResponse
import com.example.ase_project_nutrismart.Response.PurchasedGrocery
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel
import com.example.ase_project_nutrismart.Response.SelectedGrocery
import com.example.ase_project_nutrismart.Response.ExpiryResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @POST("/api/v1/auth/signin")
    fun login(@Body param: Map<String?, String?>?): Call<LoginResponse?>?

    @POST("/api/v1/auth/signup")
    fun signup(@Body param: Map<String?, String?>?): Call<SignupResponse?>?

    @GET("/api/v1/application/bmiCalc/{mass}/{height}/{age}/{gender}")
    fun bmi(
        @Path("mass") mass: String?,
        @Path("height") height: String?,
        @Path("age") age: String?,
        @Path("gender") gender: String?
    ): Call<BmiResponse?>?

    @GET("/api/v1/auth/list")
    fun userList(): Call<List<SignupListResponse?>?>?

    @GET("api/v1/master/getFoods")
    fun groceryList(): Call<PurchasedGrocery?>?

    @POST("/api/v1/application/selectedgrocery")
    fun sendSelectedGrocery(@Body model: SelectedGroceryModel?): Call<SelectedGrocery?>?

    @GET("api/v1/application/getExpiredItems")
    fun getExpiryList(@Query("userEmail") userEmail: String?): Call<ExpiryResponse?>?
}