package com.example.kiit.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KIIT on 23-12-2017.
 */

public class Adapter extends ArrayAdapter<News> {

    public Adapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }
        News current = getItem(position);
        TextView magnitude = (TextView) listItemView.findViewById(R.id.);
        TextView date =
    }

}
