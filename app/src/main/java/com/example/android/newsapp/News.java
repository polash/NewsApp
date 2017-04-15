package com.example.android.newsapp;

/**
 * Created by sksho on 15-Apr-17.
 */

public class News {

    //Title of the News
    private final String title;
    //News topic
    private final String topic;
    //Published Date of the News
    private final String publishedDate;
    //News URL
    private final String url;

    //Default Constructor
    public News(String title, String topic, String publishedDate, String url) {
        this.title = title;
        this.topic = topic;
        this.publishedDate = publishedDate;
        this.url = url;
    }

    //Getter for title
    public String getTitle() {
        return title;
    }

    //Getter for topic
    public String getTopic() {
        return topic;
    }

    //Getter for published date
    public String getPublishedDate() {
        return publishedDate;
    }

    //Getter for URL
    public String getUrl() {
        return url;
    }

}
