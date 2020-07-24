package com.example.news.data;

import com.example.news.model.Article;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Article> articleArrayList);
}
