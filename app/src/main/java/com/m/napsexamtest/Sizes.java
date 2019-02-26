package com.m.napsexamtest;

import android.content.Intent;

import java.io.Serializable;

public class Sizes  implements Serializable {
    Integer width;
    Integer height;
    String  link;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
