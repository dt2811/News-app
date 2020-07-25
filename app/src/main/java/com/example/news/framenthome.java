package com.example.news;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.data.AnswerListAsyncResponse;
import com.example.news.data.CovidAsyncRespone;
import com.example.news.data.CovidStatsBank;
import com.example.news.data.LocalNewsBank;
import com.example.news.data.WorldNewsBank;
import com.example.news.model.Article;
import com.example.news.model.Covid;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class framenthome extends Fragment {
    Covid covid=new Covid();
    List<Article> articleListLocal=new ArrayList<>();
    List<Article> articleListGlobal=new ArrayList<>();
    TextView t1,t2,t11,t13,t14,dc,dr,dd;

    RecyclerView recyclerView;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.homefragment,container,false);
        t11=view.findViewById(R.id.conf);
        t13=view.findViewById(R.id.dead);
        t14=view.findViewById(R.id.rec);
        dc=view.findViewById(R.id.dc);
        dr=view.findViewById(R.id.dr);
        dd=view.findViewById(R.id.dd);
        covid=new CovidStatsBank().getCovid(new CovidAsyncRespone() {
            @Override
            public void processFinished(Covid covid) {
                Log.d("test", "onCreateView: "+covid.getConfirmed());
                t11.setText(MessageFormat.format("{0}", covid.getConfirmed()));
                t13.setText(MessageFormat.format("{0}", covid.getDeceased()));
                t14.setText(MessageFormat.format("{0}", covid.getRecovered()));
                dc.setText(MessageFormat.format("+{0}", covid.getDailyConfirmed()));
                dr.setText(MessageFormat.format("+{0}", covid.getDailyRecovered()));
                dd.setText(MessageFormat.format("+{0}", covid.getDailyDeceased()));
            }
        });


        recyclerView=view.findViewById(R.id.recycler);
        articleListLocal=new LocalNewsBank().getArticle(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Article> articleArrayList) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
                recyclerView.setAdapter(new recycleradpater(getContext(),articleListLocal,1));

            }
        });
        articleListGlobal=new WorldNewsBank().getArticle(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Article> articleArrayList) {

            }
        });


     t2=view.findViewById(R.id.t3);
 t1=view.findViewById(R.id.t2);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setTextColor(getResources().getColor(R.color.orange));
                t2.setTextColor(getResources().getColor(R.color.grey));
                recyclerView.setAdapter(new recycleradpater(getContext(),articleListLocal,1));
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setTextColor(getResources().getColor(R.color.orange));
             t1.setTextColor(getResources().getColor(R.color.grey));
                recyclerView.setAdapter(new recycleradpater(getContext(),articleListGlobal,1));
            }
        });



        return view;
    }

}
