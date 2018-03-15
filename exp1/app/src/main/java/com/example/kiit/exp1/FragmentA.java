package com.example.kiit.exp1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by KIIT on 18-01-2018.
 */

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {

    Communicator communicator;
    ListView listView;
    String arr[] = {"Introduction","Description","Price"};
    @Override
    public void onActivityCreated(Bundle savedInstances) {

        super.onActivityCreated(savedInstances);
        listView = (ListView)getActivity().findViewById(R.id.list);
        communicator=(Communicator)getActivity();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        communicator.respond(i);
    }
}
