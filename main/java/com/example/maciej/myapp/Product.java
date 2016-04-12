package com.example.maciej.myapp;

/**
 * Created by Maciej on 2015-11-29.
 */
public class Product {

    private Long nr;

    private String name;

    private Long calories;

    private Long carbo;

    private Long protein;

    private Long fat;

    public Long getNr() {
        return nr;
    }

    public void setNr(Long nr) {
        this.nr = nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public Long getCarbo() {
        return carbo;
    }

    public void setCarbo(Long carbo) {
        this.carbo = carbo;
    }

    public Long getProtein() {
        return protein;
    }

    public void setProtein(Long protein) {
        this.protein = protein;
    }

    public Long getFat() {
        return fat;
    }

    public void setFat(Long fat) {
        this.fat = fat;
    }

}

