package com.example.ase_project_nutrismart.Response;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class ExpireData implements Serializable {

    @ColumnInfo(name = "insertionNumber")
    private int insertionNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(int userEmail) {
        this.userEmail = userEmail;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "food")
    private String food;

    @ColumnInfo(name = "userEmail")
    private int userEmail;

    @ColumnInfo(name = "purchaseDate")
    private String purchaseDate;

    @ColumnInfo(name = "expiryDate")
    private String expiryDate;


    public int getInsertionNumber() {
        return insertionNumber;
    }

    public void setInsertionNumber(int insertionNumber) {
        this.insertionNumber = insertionNumber;
    }
}
