package com.example.news.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.news.model.Article;
import com.example.news.util.Util;

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
















}