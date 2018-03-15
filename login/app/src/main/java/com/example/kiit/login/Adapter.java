package com.example.kiit.login;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by KIIT on 14-01-2018.
 */

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<country> countries;
    public Adapter(Context context,ArrayList<country> countries)
    {
        this.context=context;
        this.countries=countries;
    }
    @Override
    public int getCount()
    {
        return countries.size();
    }

    @Override
    public Object getItem(int i) {
        return countries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =layoutInflater.inflate(R.layout.cutsom,null ,false);
        TextView lang = (TextView)v.findViewById(R.id.lang);
        TextView country =(TextView)v.findViewById(R.id.country);
        country.setText(countries.get(i).getCountryname());
        lang.setText(countries.get(i).getLanguage());
        return v;
    }


}
