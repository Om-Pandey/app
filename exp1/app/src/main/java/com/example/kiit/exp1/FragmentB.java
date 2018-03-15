package com.example.kiit.exp1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by KIIT on 18-01-2018.
 */

public class FragmentB extends Fragment {

    TextView textView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.text2);
    }

    String arr1[] = {"Presenting the all new Samsung Galaxy Note", "It has the following features", "$1200"};

    public void change(int i) {
        textView.setText(arr1[i]);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }
}
