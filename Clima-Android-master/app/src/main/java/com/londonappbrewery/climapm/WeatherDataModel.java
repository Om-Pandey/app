package com.londonappbrewery.climapm;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {
    String mTemperature;
    int mCondition;
    String mCity;
    String mIconName;

    // TODO: Declare the member variables here

    public static WeatherDataModel fromJson(JSONObject jsonObject)
    {
        WeatherDataModel mWeatherDataModel = new WeatherDataModel();
        try {
            mWeatherDataModel.mCity = jsonObject.getString("name");
            mWeatherDataModel.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            mWeatherDataModel.mIconName = updateWeatherIcon(mWeatherDataModel.mCondition);
            double temp = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int twp = (int)temp;
            mWeatherDataModel.mTemperature = Integer.toString(twp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mWeatherDataModel;
    }
    // TODO: Create a WeatherDataModel from a JSON:


    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // TODO: Create getter methods for temperature, city, and icon name:




    public String getmCity() {
        return mCity;
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmIconName() {
        return mIconName;

    }
}
