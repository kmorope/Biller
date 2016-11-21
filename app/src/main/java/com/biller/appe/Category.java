package com.biller.appe;

import android.graphics.drawable.Drawable;

/**
 * Created by Ingenian on 21/11/2016.
 */

public class Category {

    private String title,date,value;
    private Drawable image;

    public Category(){

    }

    public Category(String title,String date){
        this.title = title;
        this.date = date;
    }

    public Category(String title,String date,String value){
        this.title = title;
        this.date = date;
        this.value = value;
    }

    public Category(String title,String date,String value,Drawable image){
        this.title = title;
        this.date = date;
        this.value = value;
        this.image = image;
    }

    public Category(String title,String date,Drawable image){
        this.title = title;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Drawable getImage(){
        return image;
    }


}
