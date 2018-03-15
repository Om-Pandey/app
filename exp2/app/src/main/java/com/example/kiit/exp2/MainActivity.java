package com.example.kiit.exp2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
    }

    public void addA(View view) {
        fragmentA fragmentA = new fragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.linear,fragmentA,"Add A");
        transaction.commit();
    }

    public void addB(View view) {
        frag_2 frag2 = new frag_2();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.linear,frag2,"Add B");
        fragmentTransaction.commit();
    }

    public void removeB(View view) {
        frag_2 frag2 = (frag_2) manager.findFragmentByTag("Add B");
        if(frag2 != null) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.remove(frag2);
        }
        else
            Toast.makeText(this,"Add B first",Toast.LENGTH_LONG).show();
    }

    public void replaceAB(View view) {
    }

    public void removeA(View view) {
        fragmentA fragmentA = (fragmentA)manager.findFragmentByTag("Add A");
        if(fragmentA != null) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.remove(fragmentA);
        }
        else
            Toast.makeText(this,"Add A first",Toast.LENGTH_LONG).show();
    }

    public void attachA(View view) {

    }

    public void DetachA(View view) {
    }

    public void replaceBA(View view) {
    }
}
