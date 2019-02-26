package com.m.napsexamtest;

import java.io.Serializable;

public class CategoryModel implements Serializable {
    public  String imagageUrl;
    public  String categoryImageName;

    public String getCategoryImageName() {
        return categoryImageName;
    }

    public String getImagageUrl() {
        return imagageUrl;
    }

    public void setCategoryImageName(String categoryImageName) {
        this.categoryImageName = categoryImageName;
    }

    public void setImagageUrl(String imagageUrl) {
        this.imagageUrl = imagageUrl;
    }
}
