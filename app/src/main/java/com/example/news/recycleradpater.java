package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i= new Intent(context,newspage.class);
                 context.startActivity(i);
                //Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();

            }
        });
        holder.c.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // save database
                Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class holder extends RecyclerView.ViewHolder{
         TextView t;
         ImageView i;
         CardView c;
        public holder(@NonNull View itemView) {
            super(itemView);
            c=itemView.findViewById(R.id.cardview);
            t=itemView.findViewById(R.id.title);
            i=itemView.findViewById(R.id.imageview);
        }
    }
}
