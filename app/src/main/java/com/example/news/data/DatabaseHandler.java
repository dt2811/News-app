package com.example.news.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.news.model.Article;
import com.example.news.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE="CREATE TABLE "+Util.TABLE_NAME+"("+Util.KEY_ID+" INTEGER PRIMARY KEY,"
                +Util.KEY_TITLE+" TEXT ,"+Util.KEY_IMAGE_URL+" TEXT ,"+Util.KEY_DESCRIPTION+" TEXT ,"
                +Util.KEY_ARTICLE_URL+" TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE= String.valueOf("DROP TABLE IF EXISTS");
        sqLiteDatabase.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
        onCreate(sqLiteDatabase);

    }

    public void addArticle(Article article){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Util.KEY_TITLE,article.getTitle());
        values.put(Util.KEY_IMAGE_URL,article.getImage_url());
        values.put(Util.KEY_DESCRIPTION,article.getDescription());
        values.put(Util.KEY_ARTICLE_URL,article.getArticle_url());
        db.insert(Util.TABLE_NAME,null,values);
        db.close();
    }
    public List<Article> getAllArticles(){
        SQLiteDatabase db=this.getReadableDatabase();
        List<Article> articleList=new ArrayList<>();
        String selectAll="SELECT * FROM "+Util.TABLE_NAME;
        Cursor cursor=db.rawQuery(selectAll,null);
        if(cursor.moveToFirst()){
            do {
                Article article=new Article();
                article.setId(cursor.getInt(0));
                article.setTitle(cursor.getString(1));
                article.setImage_url(cursor.getString(2));
                article.setDescription(cursor.getString(3));
                article.setArticle_url(cursor.getString(4));
                articleList.add(article);
            }while (cursor.moveToNext());
        }
        return articleList;
    }
    public void deleteArticle(Article article){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,Util.KEY_ID+"=?",new String[]{String.valueOf(article.getId())});
        db.close();
    }
















}
