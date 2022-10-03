package com.example.MyFirstApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {
    Context context;
    ArrayList user_name;
    ArrayList user_url;
    CustomerAdapter(Context context, ArrayList user_name,
                    ArrayList user_url){
        this.context = context;
        this.user_name = user_name;
        this.user_url = user_url;
    };

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.user_name_txt.setText(String.valueOf(user_name.get(position)));
        holder.user_url_txt.setText(String.valueOf(user_url.get(position)));
    }

    @Override
    public int getItemCount() {
        return user_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_url_txt,user_name_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_name_txt = itemView.findViewById(R.id.user_name_txt);
            user_url_txt = itemView.findViewById(R.id.user_url_txt);
        }
    }
}
