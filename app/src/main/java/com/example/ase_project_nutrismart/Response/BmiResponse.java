package com.example.ase_project_nutrismart.Response;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class BmiResponse implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BmiData getData() {
        return data;
    }

    public void setData(BmiData data) {
        this.data = data;
    }

    public BmiData data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ColumnInfo(name="message")
    public String message;

}
