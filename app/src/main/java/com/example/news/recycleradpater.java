package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recycleradpater extends RecyclerView.Adapter<recycleradpater.holder> {
    Context context;
    ArrayList<String> title,url;
    public recycleradpater(Context context, ArrayList<String> title, ArrayList<String> url)
    {
        this.context=context;
        this.title=title;
        this.url=url;
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.recyclerviewer, parent, false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.t.setText(title.get(position));
        //Glide.with(context).load(url.get(0)).into(holder.i);
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class holder extends RecyclerView.ViewHolder{
         TextView t;
         ImageView i;
        public holder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.title);
            i=itemView.findViewById(R.id.imageview);
        }
    }
}
