package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by sksho on 15-Apr-17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>>{

    //default url for loader
    private final String url;

    /**
     * default constructor
     * @param context
     * @param url
     */
    public NewsLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        // Perform the network request, parse the response, and extract a list of Books.
        List<News> newses = QueryUtils.fetchArticleData(url);
        return newses;
    }
}
