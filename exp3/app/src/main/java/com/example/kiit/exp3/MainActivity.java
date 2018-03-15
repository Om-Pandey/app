package com.example.kiit.exp3;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
     ViewPager viewPager=null;
     ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new Adapter(fragmentManager));
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(this);
        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(this);
        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Tab 3");
        tab3.setTabListener(this);
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    class Adapter extends FragmentPagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            android.support.v4.app.Fragment fragment = null;
            if (position == 0)
                fragment = new fragment_a();
            if (position == 1)
                fragment = new fragment_b();
            if (position == 2)
                fragment = new fragment_c();
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
