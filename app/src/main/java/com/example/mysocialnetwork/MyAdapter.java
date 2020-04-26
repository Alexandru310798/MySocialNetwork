package com.example.mysocialnetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        ViewHolder v = new ViewHolder(view);
        return v;
    }


    @Override
    public  void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        final Friend_In_List friend = list_friends.get(position);
        viewHolder.address.setText(friend.getAddress());
        viewHolder.name.setText(friend.getName());
        viewHolder.email.setText(friend.getEmail());
        viewHolder.button.setOnClickListener(new View.OnClickListener()
                                             {
                                                 @Override
                                                 public void onClick(View view)
                                                 {
                                                     Add.addFriend(friend);
                                                     Toast.makeText(context,"Now, you are friend with "+ friend.getName(),Toast.LENGTH_LONG ).show();
                                                 }
                                             }
        );
    }
    @Override
    public int getItemCount()
    {
        return list_friends.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView  email, name, address;
        public Button button;

        public ViewHolder( View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.email);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            button = itemView.findViewById(R.id.btn_add_friend);
        }
    }
}
