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
    ArrayList<String> title_global=new ArrayList<>();

    TextView t1,t2;
    ArrayList<String> url=new ArrayList<>();
    ArrayList<String> url_global=new ArrayList<>();
    RecyclerView recyclerView;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.homefragment,container,false);
        title.add("hello");
        title.add("yo");
        title.add("HOW are you");
        title_global.add("HEYGLOBAL");
        title_global.add("WHATSYP SDKFDJDFKJFDJDFJFDJDJJDFSJFDJFDJFDJFJDFJDFJFJFDJFDJFDJSKSDDJKFD");
        url_global.add("sjjffjjfjfjf");
        url.add("http://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg");
     recyclerView=view.findViewById(R.id.recycler);
     t2=view.findViewById(R.id.t3);
 t1=view.findViewById(R.id.t2);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(new recycleradpater(getContext(),title,url));
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(new recycleradpater(getContext(),title_global,url_global));
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new recycleradpater(getContext(),title,url));
        return view;
    }

}
