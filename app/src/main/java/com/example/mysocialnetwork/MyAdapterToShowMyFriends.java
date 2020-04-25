package com.example.mysocialnetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterToShowMyFriends {

    private List<Friend_In_List> list_friends;
    private Context context;

    public MyAdapterToShowMyFriends(List<Friend_In_List> list_friends, Context context) {
        this.list_friends = list_friends;
        this.context = context;
    }


    public MyAdapterToShowMyFriends.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_to_show, parent,false);
        return new MyAdapterToShowMyFriends.ViewHolder(view);
    }




    public int getItemCount()
    {
        return list_friends.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView email, name, address;


        public ViewHolder( View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.email_friend);
            name = itemView.findViewById(R.id.name_friend);
            address = itemView.findViewById(R.id.address_friend);
        }
    }
}
