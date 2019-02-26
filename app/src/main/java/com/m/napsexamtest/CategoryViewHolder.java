package com.m.napsexamtest;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
      public  TextView textView ;
      public ImageView imageView;

    public CategoryViewHolder(View context) {
        super(context);
        textView = context.findViewById(R.id.textView);
        imageView = context.findViewById(R.id.imageView);


    }
}
