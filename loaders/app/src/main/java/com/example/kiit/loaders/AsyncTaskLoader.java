package com.example.kiit.loaders;

import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by KIIT on 11-03-2018.
 */

public class AsyncTaskLoader extends android.content.AsyncTaskLoader<ArrayList<String>> {
    ArrayList<String> names;
    public AsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public ArrayList<String> loadInBackground() {
        return loadnames();
    }
     private ArrayList<String> loadnames()
     {
         names.add("John");
         names.add("Jay");
         names.add("Joh");
         names.add("Justin");
         names.add("Jumper");
         names.add("Jack");
         return names;
     }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        forceLoad();
    }
}
