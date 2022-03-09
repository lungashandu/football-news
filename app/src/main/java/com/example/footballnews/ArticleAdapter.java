package com.example.footballnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArticleAdapter extends ArrayAdapter<Article> {
    public ArticleAdapter(@NonNull Context context, @NonNull ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        String topic = currentArticle.getTopic();
        TextView topicTextView = listItemView.findViewById(R.id.topic_textView);
        topicTextView.setText(topic);

        String category = currentArticle.getCategory();
        TextView categoryTextView = listItemView.findViewById(R.id.category_TextView);
        categoryTextView.setText(category);

        String datePublished = createDateFormat(currentArticle.getDate());
        TextView dateTextView = listItemView.findViewById(R.id.date_TextView);
        dateTextView.setText(datePublished);

        return listItemView;
    }

    public String createDateFormat(String date) {
        final String LOCATION_SEPARATOR = "T";
        if (date.contains(LOCATION_SEPARATOR)) {
            String[] datePublished = date.split(LOCATION_SEPARATOR);
            return datePublished[0];
        } else {
            return date;
        }
    }

}
