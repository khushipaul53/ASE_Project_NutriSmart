package com.example.ase_project_nutrismart.Model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.example.ase_project_nutrismart.Response.Grocery;

import java.util.ArrayList;

public class SelectedGroceryModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public ArrayList<Grocery> getData() {
        return data;
    }

    public void setData(ArrayList<Grocery> data) {
        this.data = data;
    }

    @ColumnInfo(name="data")
    public ArrayList<Grocery> data;

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @ColumnInfo(name="purchaseDate")
    public String purchasedDate;

    @ColumnInfo(name="userEmail")
    public String userEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
