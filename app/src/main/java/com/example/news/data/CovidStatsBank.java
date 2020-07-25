package com.example.news.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.news.controller.AppController;
import com.example.news.model.Covid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CovidStatsBank {
    List<Covid> covidList=new ArrayList<>();
    Covid covid=new Covid();

    private String url="https://api.covid19india.org/data.json";
    public Covid getCovid(final CovidAsyncRespone callback){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("statewise");
                    JSONObject jsonObject=jsonArray.getJSONObject(0);

                    covid.setConfirmed(jsonObject.getInt("confirmed"));
                    covid.setDailyConfirmed(jsonObject.getInt("deltaconfirmed"));
                    covid.setDailyDeceased(jsonObject.getInt("deltadeaths"));
                    covid.setDailyRecovered(jsonObject.getInt("deltarecovered"));
                    covid.setDeceased(jsonObject.getInt("deaths"));
                    covid.setRecovered(jsonObject.getInt("recovered"));
                    Log.d("test", "onResponse: "+covid.getConfirmed());

                } catch (JSONException e) {
                    Log.d("test", "onResponse: ");
                    e.printStackTrace();
                }if(null!=callback) callback.processFinished(covid);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
        return covid;
    }


}
