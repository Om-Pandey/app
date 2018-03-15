package com.example.kiit.earthquake;

/**
 * Created by KIIT on 23-12-2017.
 */

public class News {

    private double mag;
    private String place;
    private String Date;
    public News(double m , String p , String d)
    {
        mag = m;
        place = p;
        Date =d ;
    }
    public double getmag(){return mag;}
    public String getPlace(){return place;}
    public String getDate(){return Date;}

}
