package com.example.ase_project_nutrismart.Response;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;

@Entity
public class BmiData implements Serializable {

    public double getbMI() {
        return bMI;
    }

    public void setbMI(double bMI) {
        this.bMI = bMI;
    }

    public double getProteinNeeded() {
        return proteinNeeded;
    }

    public void setProteinNeeded(double proteinNeeded) {
        this.proteinNeeded = proteinNeeded;
    }

    public double getCarbsNeeded() {
        return carbsNeeded;
    }

    public void setCarbsNeeded(double carbsNeeded) {
        this.carbsNeeded = carbsNeeded;
    }

    public double getFatsNeeded() {
        return fatsNeeded;
    }

    public void setFatsNeeded(double fatsNeeded) {
        this.fatsNeeded = fatsNeeded;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    @ColumnInfo(name="bMI")
    public double bMI;

    @ColumnInfo(name="proteinNeeded")
    public double proteinNeeded;

    @ColumnInfo(name="carbsNeeded")
    public double carbsNeeded;

    @ColumnInfo(name="fatsNeeded")
    public double fatsNeeded;


    @ColumnInfo(name="calorie")
    public double calorie;
}

