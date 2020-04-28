package com.example.mysocialnetwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Show_My_Infos extends Fragment {
    public String myName = "Nitulescu Alexandru", myEmail= "alexandrunitulescu@yahoo.com",myAge= "22";
    TextView my_Infos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.show_me, container, false);
        my_Infos = view.findViewById(R.id.my_infos);
        String my_Infos_String = "  I am : " + myName + "\nYou can find me at : " + myEmail + "\n I am " + myAge + " years old";
        my_Infos.setText(my_Infos_String);
        return view;
    }

}
