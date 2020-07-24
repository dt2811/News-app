package com.example.news.data;

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

public class LocalNewsBank {
    ArrayList<Article> articleArrayList=new ArrayList<>();
    private String url="http://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=6dd4184620bf4fab958f2b2c2055ae19";
    public List<Article> getArticle(final AnswerListAsyncResponse callback){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("articles");
                    for(int i=0;i<10;i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        Article article=new Article();
                        article.setTitle(jsonObject.getString("title"));
                        article.setImage_url(jsonObject.getString("urlToImage"));
                        article.setDescription(jsonObject.getString("description"));
                        article.setArticle_url(jsonObject.getString("url"));
                        articleArrayList.add(article);

                    }if(null!=callback) callback.processFinished(articleArrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

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
