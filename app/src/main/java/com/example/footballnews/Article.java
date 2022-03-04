package com.example.footballnews;

public class Article {

    private final String mTopic;
    private final String mCategory;
    private final String mDate;

    public Article(String topic, String category, String date) {
        this.mTopic = topic;
        this.mCategory = category;
        this.mDate = date;
    }

    public String getTopic() {
        return mTopic;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getDate() {
        return mDate;
    }
}
