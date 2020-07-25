package com.example.news.model;

public class Covid {
    private int dailyConfirmed;
    private int dailyRecovered;
    private int dailyDeceased;
    private int confirmed;
    private int recovered;
    private int deceased;

    public int getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(int dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public int getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(int dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public int getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(int dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeceased() {
        return deceased;
    }

    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }

    public Covid() {
    }

    public Covid(int dailyConfirmed, int dailyRecovered, int dailyDeceased, int confirmed, int recovered, int deceased) {
        this.dailyConfirmed = dailyConfirmed;
        this.dailyRecovered = dailyRecovered;
        this.dailyDeceased = dailyDeceased;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deceased = deceased;
    }
}
