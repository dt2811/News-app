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

import java.util.ArrayList;

public class framentsearch extends Fragment {
    String quer=" ";
    boolean condition;
    ArrayList<String> title_search=new ArrayList<>();
    ArrayList<String> url_image=new ArrayList<>();
    RecyclerView recyclerView1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.searchfragment,container,false);
        recyclerView1=view.findViewById(R.id.recycler1);
        SearchView searchView=view.findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
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
        title_search.add("hello");
        title_search.add("waag");
        url_image.add("YO");
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView1.setAdapter(new recycleradpater(getContext(),title_search,url_image));
    }
}
