package com.example.androidrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>
{
    List<User> users;


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position)
    {
        holder.tvName.setText(users.get(position).getName());
        holder.tvScore.setText("" + users.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvScore;
        public UserViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvName = itemView.findViewById(R.id.textName);
            tvScore = itemView.findViewById(R.id.textScore);
        }
    }
}
