package com.example.news.model;

public class Article {
    private int id;
    private String title;
    private String image_url;
    private String description;
    private String article_url;

    public Article() {
    }

    public Article(String title, String image_url, String description, String article_url) {
        this.title = title;
        this.image_url = image_url;
        this.description = description;
        this.article_url = article_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }
}
