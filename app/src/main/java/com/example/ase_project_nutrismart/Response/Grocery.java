package com.example.ase_project_nutrismart.Response;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Grocery implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "food")
    private String food;


    @ColumnInfo(name = "measure")
    private String measure;


    @ColumnInfo(name = "measuringUnit")
    private String measuringUnit;

    @ColumnInfo(name = "grams")
    private String grams;


    @ColumnInfo(name = "calories")
    private String calories;

    @ColumnInfo(name = "protein")
    private String protein;

    @ColumnInfo(name = "fat")
    private String fat;

    @ColumnInfo(name = "sno")
    private int sno;

    @ColumnInfo(name = "fibers")
    private String fibers;

    @ColumnInfo(name = "saturatedFat")
    private String saturatedFat;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "carbs")
    private String carbs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public String getGrams() {
        return grams;
    }

    public void setGrams(String grams) {
        this.grams = grams;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getFibers() {
        return fibers;
    }

    public void setFibers(String fibers) {
        this.fibers = fibers;
    }

    public String getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }
}
