package com.example.ase_project_nutrismart.Response;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class PurchasedGrocery implements Serializable {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

