package com.example.ase_project_nutrismart.Retrofit

import okhttp3.logging.HttpLoggingInterceptor.setLevel
import okhttp3.OkHttpClient.Builder.addInterceptor
import okhttp3.OkHttpClient.Builder.build
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import com.example.ase_project_nutrismart.Retrofit.APIClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import com.example.ase_project_nutrismart.Response.LoginResponse
import com.example.ase_project_nutrismart.Response.SignupResponse
import retrofit2.http.GET
import com.example.ase_project_nutrismart.Response.BmiResponse
import com.example.ase_project_nutrismart.Response.SignupListResponse
import com.example.ase_project_nutrismart.Response.PurchasedGrocery
import com.example.ase_project_nutrismart.Model.SelectedGroceryModel
import com.example.ase_project_nutrismart.Response.SelectedGrocery
import com.example.ase_project_nutrismart.Response.ExpiryResponse

object APIClient {
    private var retrofit: Retrofit? = null
    @JvmStatic
    val client: Retrofit?
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = Builder().addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl("https://nutrismartserver.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit
        }
}