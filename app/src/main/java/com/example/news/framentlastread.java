package com.example.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.data.DatabaseHandler;

import java.util.ArrayList;

public class framentlastread extends Fragment {
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> url=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.late,container,false);
        DatabaseHandler db=new DatabaseHandler(getContext());
        RecyclerView recyclerView;
        recyclerView=view.findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new recycleradpater(getContext(),db.getAllArticles(),2));



        return view;
    }
}
