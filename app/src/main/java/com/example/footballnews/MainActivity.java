package com.example.footballnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));
        articles.add(new Article("Abramovich hands ‘stewardship and care of Chelsea’ to charitable foundation", "News", "2022/02/26"));

        ArticleAdapter adapter = new ArticleAdapter(this, articles);
        ListView articleListView = findViewById(R.id.newsItem_listview);
        articleListView.setAdapter(adapter);

    }
}