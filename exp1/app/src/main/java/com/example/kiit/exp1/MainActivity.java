package com.example.kiit.exp1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int data) {
      FragmentB fragment2 = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment4);
      fragment2.change(data);
    }
}
