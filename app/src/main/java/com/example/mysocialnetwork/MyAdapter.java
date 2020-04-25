package com.example.mysocialnetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Friend_In_List> list_friends;
    private Context context;

    public MyAdapter(List<Friend_In_List> list_friends, Context context) {
        this.list_friends = list_friends;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_in_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public  void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        Friend_In_List friend = list_friends.get(position);
        viewHolder.address.setText(friend.getAddress());
        viewHolder.name.setText(friend.getName());
        viewHolder.age.setText(friend.getAge());
        viewHolder.email.setText(friend.getEmail());
    }
    @Override
    public int getItemCount()
    {
        return list_friends.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView age, email, name, address;

        public ViewHolder( View itemView) {
            super(itemView);
            age = itemView.findViewById(R.id.age);
            email = itemView.findViewById(R.id.email);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
        }
    }
}
