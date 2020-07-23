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

import java.util.ArrayList;

public class framenthome extends Fragment {
        ArrayList<String> title=new ArrayList<>();
    ArrayList<String> url=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homefragment,container,false);
        title.add("hello");
        title.add("yo");
        title.add("HOW are you");
        url.add("http://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg");
        RecyclerView recyclerView=view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new recycleradpater(getContext(),title,url));
        return view;
    }
}
