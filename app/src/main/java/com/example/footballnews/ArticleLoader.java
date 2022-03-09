package com.example.footballnews;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.AsyncTaskLoader;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {
    private static final String LOG_TAG = ArticleLoader.class.getName();
    private String mUrl;

    public ArticleLoader(@NonNull Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Nullable
    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Article> result = QueryUtils.fetchArticleData(mUrl);
        return result;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
