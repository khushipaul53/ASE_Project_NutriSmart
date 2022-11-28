package com.example.ase_project_nutrismart.Response;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.ArrayList;

@Entity
public class ExpiryResponse {

    @ColumnInfo(name="data")
    public ArrayList<Grocery> data;
}
