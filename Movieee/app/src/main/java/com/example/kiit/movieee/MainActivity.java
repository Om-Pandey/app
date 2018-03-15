package com.example.kiit.movieee;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    Button button;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JsonTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
            }
        });
    }

    class JsonTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpsURLConnection urlConnection = null;
            BufferedReader reader;
            String movie = null;
            String year = null;
            try {
                URL url = new URL(strings[0]);
                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream stream = urlConnection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null)
                    stringBuffer.append(line);
                String finalJson = stringBuffer.toString();
                JSONObject jsonObject = new JSONObject(finalJson);
                JSONArray jsonArray = jsonObject.getJSONArray("movies");
                JSONObject finalObject = jsonArray.getJSONObject(0);
                movie = finalObject.getString("movie");
                year = finalObject.getString("year");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();

            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
           textView.setText(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}