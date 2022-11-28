package com.example.ase_project_nutrismart.Response;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class ExpiryResponse implements Serializable {

    public ArrayList<ExpireData> getData() {
        return data;
    }

    public void setData(ArrayList<ExpireData> data) {
        this.data = data;
    }

    @ColumnInfo(name="data")
    public ArrayList<ExpireData> data;


}

