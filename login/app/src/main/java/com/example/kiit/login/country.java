package com.example.kiit.login;

/**
 * Created by KIIT on 14-01-2018.
 */

public class country {
    private String countryname;
    private String language;
    public country(String country , String langi)
    {
        countryname = country;
        language = langi;
    }
    public String getCountryname(){return countryname;}
    public String getLanguage(){return language;}

}
