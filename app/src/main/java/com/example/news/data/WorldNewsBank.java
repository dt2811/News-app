package com.example.news.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.news.controller.AppController;
import com.example.news.model.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WorldNewsBank {
    ArrayList<Article> articleArrayList=new ArrayList<>();
    private String url="https://api.nytimes.com/svc/topstories/v2/world.json?api-key=ENTER-KEY-HERE";
    public List<Article> getArticle(final AnswerListAsyncResponse callback){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray=response.getJSONArray("results");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        Article article=new Article();
                        JSONArray jsonArray1=jsonObject.getJSONArray("multimedia");
                        JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                        article.setImage_url(jsonObject1.getString("url"));
                        article.setTitle(jsonObject.getString("title"));

                        article.setDescription(jsonObject.getString("abstract"));
                        article.setArticle_url(jsonObject.getString("url"));
                        articleArrayList.add(article);
                        Log.d("Title", "onResponse: "+article.getTitle());

                    }
                } catch (JSONException e) {

                    e.printStackTrace();
                }if(null!=callback) callback.processFinished(articleArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
        return articleArrayList;
    }
}
