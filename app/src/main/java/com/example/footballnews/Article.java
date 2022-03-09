package com.example.footballnews;

public class Article {

    private final String mTopic;
    private final String mCategory;
    private final String mDate;
    private final String mUrl;

    public Article(String topic, String category, String date, String url) {
        this.mTopic = topic;
        this.mCategory = category;
        this.mDate = date;
        this.mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }
}
