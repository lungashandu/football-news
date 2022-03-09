package com.example.footballnews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Loader;
import android.app.LoaderManager;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Article>> {

    private static final String REQUEST_URL = "https://content.guardianapis.com/search?q=football&api-key=test";
    private ArticleAdapter adapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArticleAdapter(this, new ArrayList<>());
        ListView articleListView = findViewById(R.id.newsItem_listview);
        mEmptyStateTextView = findViewById(R.id.emptyState);

        articleListView.setAdapter(adapter);
        articleListView.setEmptyView(mEmptyStateTextView);

        articleListView.setOnItemClickListener((adapterView, view, position, l) -> {
            Article currentArticle = adapter.getItem(position);
            Uri articleUri = Uri.parse(currentArticle.getUrl());

            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);
            startActivity(websiteIntent);
        });

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        } else {
            ProgressBar progressBar = findViewById(R.id.loading_spinner);
            progressBar.setVisibility(View.GONE);

            mEmptyStateTextView.setText(R.string.noConnection);
        }

    }

    @NonNull
    @Override
    public Loader<List<Article>> onCreateLoader(int id, @Nullable Bundle args) {
        return new ArticleLoader(this, REQUEST_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Article>> loader, List<Article> data) {
        ProgressBar progressBar = findViewById(R.id.loading_spinner);
        progressBar.setVisibility(View.GONE);

        adapter.clear();

        if (data != null && !data.isEmpty()) {
            adapter.addAll(data);
        }

        mEmptyStateTextView.setText(R.string.empty);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Article>> loader) {
        adapter.clear();
    }
}