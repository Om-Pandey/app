package com.londonappbrewery.climapm;

import android.app.VoiceInteractor;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.impl.client.FutureRequestExecutionService;


public class WeatherController extends AppCompatActivity {

    // Constants:
    final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    // App ID to use OpenWeather data
    final String APP_ID = "e72____PLEASE_REPLACE_ME_____13";
    // Time between location updates (5000 milliseconds or 5 seconds)
    final long MIN_TIME = 5000;
    // Distance between location updates (1000m or 1km)
    final float MIN_DISTANCE = 1000;

    // TODO: Set LOCATION_PROVIDER here:
    LocationManager locationManager;
    LocationListener locationListener;

    String LOCATION_PROVIDER = LocationManager.NETWORK_PROVIDER;


    // Member Variables:
    TextView mCityLabel;
    ImageView mWeatherImage;
    TextView mTemperatureLabel;

    // TODO: Declare a LocationManager and a LocationListener here:


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_controller_layout);

        // Linking the elements in the layout to Java code
        mCityLabel = (TextView) findViewById(R.id.locationTV);
        mWeatherImage = (ImageView) findViewById(R.id.weatherSymbolIV);
        mTemperatureLabel = (TextView) findViewById(R.id.tempTV);
        ImageButton changeCityButton = (ImageButton) findViewById(R.id.changeCityButton);
        // TODO: Add an OnClickListener to the changeCityButton here:

    }


    // TODO: Add onResume() here:

    @Override
    protected void onResume() {
        super.onResume();
        getWeatherForCurrentLocation();
    }

    private void Networking(RequestParams requestParams) {
        AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();
        mAsyncHttpClient.get(WEATHER_URL,requestParams,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                WeatherDataModel mWeatherDataModel = WeatherDataModel.fromJson(response);
                updateUI(mWeatherDataModel);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }


    // TODO: Add getWeatherForNewCity(String city) here:
    public void getWeatherForCurrentLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String lattitude = String.valueOf(location.getLatitude());
                String longitude = String.valueOf(location.getLongitude());

                RequestParams mRequestParams = new RequestParams();
                mRequestParams.add("lat", lattitude);
                mRequestParams.add("longitude", longitude);
                mRequestParams.add("App_id", APP_ID);
                Networking(mRequestParams);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
    }

    // TODO: Add getWeatherForCurrentLocation() here:



    // TODO: Add letsDoSomeNetworking(RequestParams params) here:



    // TODO: Add updateUI() here:
    public void updateUI(WeatherDataModel weatherDataModel)
    {
      mCityLabel.setText(weatherDataModel.getmCity());
      mTemperatureLabel.setText(weatherDataModel.getmTemperature());
      int resId  = getResources().getIdentifier(weatherDataModel.getmIconName(),"drawable",getPackageName());
      mWeatherImage.setImageResource(resId);
    }


    // TODO: Add onPause() here:



}
