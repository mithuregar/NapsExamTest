package com.m.napsexamtest;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VolleyRequestApi {




    public static void notificationRequest( final Context context, String catId)
    {
        final RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);
        String URL = String.format(ServiceConstant.VIDEO_Link,catId);
        JSONObject data = new JSONObject();
        try
        {
            data.put("operation", "create");
         //   data.put("notification_key_name", notificationKey);
           // data.put("registration_ids", new JSONArray(registrationToken));
        } catch (Exception e)
        {

        }

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, URL,

                data,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {

                        String notification = response.optString("notification_key");
                      //  notificationListener.notificationKey(response);
                        if (notification != null)
                        {




                        }

                        Log.d("test", String.valueOf(notification));



                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        //        loadingDialog.dismiss();
                        //   Handle Error
                       // notificationListener.error(error.getMessage());
                    }
                })
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
        requestQueue.add(postRequest);


    }
}
