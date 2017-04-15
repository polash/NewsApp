package com.example.android.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sksho on 15-Apr-17.
 */

public class NewsAdapter extends ArrayAdapter<News> {


    /**
     * default constructor
     * @param context
     * @param newses
     */
    public NewsAdapter(Activity context, List<News> newses) {
        super(context, 0, newses);
    }

    /**
     * getview method here views update
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }

        News currentNews = getItem(position);

        //find views with their ids
        TextView titleTextView = (TextView)convertView.findViewById(R.id.news_title);
        TextView topicTextView = (TextView)convertView.findViewById(R.id.topic_name);
        TextView dateView = (TextView)convertView.findViewById(R.id.publishedDate);
        TextView timeView = (TextView)convertView.findViewById(R.id.publishedTime);

        //set views
        titleTextView.setText(currentNews.getTitle());
        topicTextView.setText(currentNews.getTopic());


        //Date conversion
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date date = null;
        try {
            date = dateFormat.parse(currentNews.getPublishedDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //date null check
        if (date != null){
            SimpleDateFormat newDateFormat= new SimpleDateFormat("LLL dd, yyyy");
            String finalDate = newDateFormat.format(date);
            dateView.setText(finalDate.toString());

            SimpleDateFormat newTimeFormat= new SimpleDateFormat("h:mm a");
            String finalTime = newTimeFormat.format(date);
            timeView.setText(finalTime.toString());
        }
        return convertView;
    }
}
