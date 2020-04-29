package com.example.mysocialnetwork;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add extends Fragment {

    static Button addBtn;

    public Add() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add, container, false);
        addBtn = view.findViewById(R.id.btn_add_friend);

        return view;
    }

    public static void addFriend(final Friend_In_List friend_in_list)
    {
        addBtn.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          User user = new User();
                                          user.setAge(friend_in_list.getAge());
                                          user.setAddress(friend_in_list.getAddress());
                                          user.setName(friend_in_list.getName());
                                          user.setEmail(friend_in_list.getEmail());
                                         MainActivity.myAppDatabase.myDao.addUser(user);
                                      }
                                  }
        );
    }
}
