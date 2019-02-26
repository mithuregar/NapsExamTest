package com.m.napsexamtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoriesAdapter categoriesAdapter;
    ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =  findViewById(R.id.rv);
//        CategoryModel movieList = new CategoryModel();
//            movieList.setCategoryImageName("AddText");
//            movieList.setImagageUrl("https://i.vimeocdn.com/video/761814137_100x75.jpg?r=pad");
//        CategoryModel movieList1 = new CategoryModel();
//        movieList1.setCategoryImageName("AddText");
//        movieList1.setImagageUrl("https://i.vimeocdn.com/video/761814137_100x75.jpg?r=pad");
//            categoryModels.add(movieList1);
//        categoryModels.add(movieList);
        RequestQueue queue = Volley.newRequestQueue(this);

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, ServiceConstant.ALLCATE, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        try {
                            JSONArray cast = response.getJSONArray("data");
                            CategoryModel categoryModel1;
                            for (int i=0; i<cast.length(); i++) {
                                categoryModel1 = new CategoryModel();
                                JSONObject actor = cast.getJSONObject(i);
                                String name = actor.getString("name");
                                JSONObject jsonObject = actor.getJSONObject("pictures");

                              //  Log.d("Response", jsonObject.toString());
                                JSONArray size = jsonObject.getJSONArray("sizes");
                                JSONObject jsonObject1 = size.getJSONObject(0);
                                String link = jsonObject1.getString("link");
                                Log.d("ytff",link);
                                categoryModel1.setCategoryImageName(name);
                                categoryModel1.setImagageUrl(link);
                                categoryModels.add(categoryModel1);
                            }
                            Log.d("text",categoryModels.toString());
                            categoriesAdapter = new CategoriesAdapter(MainActivity.this,categoryModels);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(mLayoutManager);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                            recyclerView.setAdapter(categoriesAdapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        )
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "bearer b2918607b4301812914f5a5141c4d7da");
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");

                return headers;
            }
        };

// add it to the RequestQueue
        queue.add(getRequest);

    }
}
