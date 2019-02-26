package com.m.napsexamtest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    ArrayList<CategoryModel> categoryModels;
    MainActivity mainActivity;
   public CategoriesAdapter(MainActivity mainActivity,ArrayList<CategoryModel>categoryModels){
       this.categoryModels=categoryModels;
       this.mainActivity = mainActivity;

   }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
                   final CategoryModel categoryModel = categoryModels.get(position);
        Glide.with(mainActivity)
                .load(categoryModel.imagageUrl)
                .into(holder.imageView);
        holder.textView.setText(categoryModel.getCategoryImageName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mainActivity,SecondActvity.class);
//                intent.putExtra("catname",categoryModel.getCategoryImageName());
//                mainActivity.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (categoryModels !=null ? categoryModels.size():0);
    }
}
