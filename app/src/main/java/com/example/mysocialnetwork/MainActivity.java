package com.example.mysocialnetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Friend_In_List> new_possible_friends, friends;
    private String url = "https://jsonplaceholder.typicode.com/users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        recyclerView = findViewById(R.id.my_recycler_view_to_show_friends);
        recyclerView.setLayoutManager(new LinearLayoutManager());
        new_possible_friends = new ArrayList<>();
        friends = new ArrayList<>();

        adapter = new MyAdapter(new_possible_friends,this);
        recyclerView.setAdapter(adapter);
        loadRecyclerViewData();
        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState != null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new Home()).commit();

        }
    }

    private void loadRecyclerViewData()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    progressDialog.dismiss();
                        JSONArray jsonArray = new JSONArray(stringRequest);
                        for(int i=0;i<jsonArray.length();i++)
                        {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            JSONArray jsonAddress = jsonObject.getJSONArray("address");
                            String address = "";
                            for(int j=0;j<jsonAddress.length();j++)
                            {
                                JSONObject addressJsonObj = jsonAddress.getJSONObject(j);
                                address.concat(addressJsonObj,getString());
                            }

                            Friend_In_List friend_aux = new Friend_In_List(jsonObject.getString("username"), address, jsonObject.getString("email"));

                            if(friends.contains(friend_aux) == FALSE)
                            {
                                new_possible_friends.add(friend_aux);
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}