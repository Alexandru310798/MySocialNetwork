package com.example.mysocialnetwork;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener {
    public static Button add_button;
    public static Button show_button;
    public static Button my_infos_button;
    public static Button maps_button;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        add_button = view.findViewById(R.id.btn_search);
        add_button.setOnClickListener(this);
        show_button = view.findViewById(R.id.btn_show_my_friends);
        show_button.setOnClickListener(this);
        my_infos_button = view.findViewById(R.id.btn_me);
        my_infos_button.setOnClickListener(this);
        maps_button = view.findViewById(R.id.btn_maps);
        maps_button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.btn_add_friend:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Add()).addToBackStack(null).commit();
                break;
            case R.id.btn_me:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Show_My_Infos()).addToBackStack(null).commit();
                break;
            case R.id.btn_show_my_friends:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Show_Friends()).addToBackStack(null).commit();
                break;

        }
    }
}
