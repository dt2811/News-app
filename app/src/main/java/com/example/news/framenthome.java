package com.example.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class framenthome extends Fragment {
        ArrayList<String> title=new ArrayList<>();
    TextView t1;
    ArrayList<String> url=new ArrayList<>();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.homefragment,container,false);
        title.add("hello");
        title.add("yo");
        title.add("HOW are you");
        url.add("http://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg");
        RecyclerView recyclerView=view.findViewById(R.id.recycler);
 t1=view.findViewById(R.id.t2);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("Clicked");
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new recycleradpater(getContext(),title,url));
        return view;
    }

}
