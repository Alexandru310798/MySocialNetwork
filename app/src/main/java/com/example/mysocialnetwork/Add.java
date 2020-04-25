package com.example.mysocialnetwork;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;


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
