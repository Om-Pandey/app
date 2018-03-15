package com.example.kiit.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ArrayList<country> arrayList= new ArrayList<country>();
        arrayList.add(new country("India","Hindi"));
        arrayList.add(new country("Portugal","Portugese"));
        arrayList.add(new country("Spain","Spanish"));
        arrayList.add(new country("France","French"));
        arrayList.add(new country("Tanzania","Kiswahili"));
        arrayList.add(new country("South Africa","Africanas"));
        arrayList.add(new country("Germany","German"));
        arrayList.add(new country("Latin America","Miwok"));
        arrayList.add(new country("Australia","N/A"));
        arrayList.add(new country("Vietnam","Vietnamese"));
        GridView gridView = (GridView) findViewById(R.id.grid);
        Adapter adapter = new Adapter(this,arrayList);
        gridView.setAdapter(adapter);


    }
}
