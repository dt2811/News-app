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

import com.bumptech.glide.Glide;
import com.example.news.data.DatabaseHandler;
import com.example.news.model.Article;

import java.util.ArrayList;
import java.util.List;

public class recycleradpater extends RecyclerView.Adapter<recycleradpater.holder> {
    Context context;
    int where;

    List<Article> articleList;
    public recycleradpater(Context context,  List<Article> articleList,int where)
    {
        this.articleList=articleList;
        this.context=context;
        this.where=where;

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
        final Article article=articleList.get(position);
        holder.t.setText(article.getTitle());
        Glide.with(context).load(article.getImage_url()).into(holder.i);
        holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Intent i= new Intent(context,newspage.class);
//               i.putExtra("title",article.getTitle());
//               i.putExtra("image_url",article.getImage_url());
//               i.putExtra("content",article.getDescription());
//               i.putExtra("article_url",article.getArticle_url());
//                 context.startActivity(i);
                //Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();

            }
        });
        holder.c.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // save database
                DatabaseHandler db=new DatabaseHandler(context);
                if(where==1) {
                    if (article.getSaved() == 0) {
                        db.addArticle(article);
                        article.setSaved(1);
                        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Already Saved", Toast.LENGTH_SHORT).show();
                    }
                }
                if(where==2){

                    db.deleteArticle(article);
                    article.setSaved(0);
                }



                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
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
