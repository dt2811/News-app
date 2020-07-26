package com.example.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class framentsearch extends Fragment {
    String quer=" ";
    boolean condition;
    private String url;
    List<Article> articleList=new ArrayList<>();
    RecyclerView recyclerView1;
    private int length;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.searchfragment,container,false);
        recyclerView1=view.findViewById(R.id.recycler1);
        SearchView searchView=view.findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                 quer=" ";
                quer=s;
            display();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });




        return view;
    }
    public void display(){
        // API VOLLEY SEARCHING CODE WITH QUER AS QUERY GIVEN BY USER
        articleList.clear();
        url="https://gnews.io/api/v3/search?q="+quer+"&token=b06baf6b60a22fd659f2d61388d47c6e";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray = response.getJSONArray("articles");
                    if(jsonArray.length()>=20){
                        length=20;
                    } else {
                        length=jsonArray.length();
                    }
                    for (int i = 0; i < length; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Article article = new Article();


                            article.setImage_url(jsonObject.getString("image"));



                        article.setTitle(jsonObject.getString("title"));

                        article.setDescription(jsonObject.getString("description"));
                        article.setArticle_url(jsonObject.getString("url"));
                        articleList.add(article);



                    }
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
                recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView1.setAdapter(new recycleradpater(getContext(),articleList,1));
    }
}
