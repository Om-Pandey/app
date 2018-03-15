package com.example.kiit.earthquake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<News> news = new ArrayList<News>();
        news.add(new News(7.2,"San Francisco" , "Feb 02,1965"));
        news.add(new News(6.8,"New York" , "Mar 03,2011"));
        news.add(new News(3.2,"Paris" , "Dec 13,1966"));
        news.add(new News(4.8,"Tokyo" , "Jul 12,1985"));
        news.add(new News(2.3,"London" , "Jun 17,2001"));
        news.add(new News(7.5,"Japan" , "Feb 02,2011"));
        news.add(new News(9.3,"Cuba" , "Nov 29,2016"));
        news.add(new News(10.2,"Las Vegas" , "May 21,2014"));
        news.add(new News(4.3,"India" , "Feb 23,2011"));
        news.add(new News(3.4,"Nepal" , "Apr 02,2004"));
        news.add(new News(5.4,"Sri Lanka" , "Nov 23,2015"));
        ListView listView = (ListView)(findViewById(R.id.list_item));
        Adapter adapter = new Adapter(this,news);
        listView.setAdapter(adapter);

    }
}
