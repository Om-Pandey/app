package com.example.kiit.loaders;

import android.support.v4.content.*;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList>{

    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    ArrayList<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.item_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recycleAdapter = new RecycleAdapter(names);
        recyclerView.setAdapter(recycleAdapter);

        getSupportLoaderManager().initLoader(0,null,this);
    }

    @Override
    public Loader<ArrayList> onCreateLoader(int i, Bundle bundle) {
        Loader mLoader = new AsyncTaskLoader(getApplicationContext()) {
            @Override
            public Object loadInBackground() {
                return loadInBackground();
            }
        };
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList> loader, ArrayList arrayList) {
       names.clear();
       names.addAll(arrayList);
       recycleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<ArrayList> loader) {
        names.clear();
    }
}
