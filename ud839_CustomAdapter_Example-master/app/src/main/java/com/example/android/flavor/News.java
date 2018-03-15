package com.example.android.flavor;

/**
 * Created by KIIT on 23-12-2017.
 */

public class News {

    private double mag;
    private String place;
    private long Date;
    public News(double m , String p , long d)
    {
        mag = m;
        place = p;
        Date =d ;
    }
    public double getmag(){return mag;}
    public String getPlace(){return place;}
    public long getDate(){return Date;}

}
