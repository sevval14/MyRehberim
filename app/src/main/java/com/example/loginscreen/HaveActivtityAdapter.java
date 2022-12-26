package com.example.loginscreen;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class HaveActivtityAdapter extends RecyclerView.Adapter<HaveActivtityAdapter.MyViewHolder> {
    Context context;
    ArrayList<News> newsArrayList;

    public HaveActivtityAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context=context;
        this.newsArrayList=newsArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.havelayout,parent,false );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        News news = newsArrayList.get(position);
        holder.header.setText(news.heading);
        holder.head.setText(news.head);
        holder.titleImage.setImageResource(news.titleImage);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView titleImage;
        TextView header;
        TextView head;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage=itemView.findViewById(R.id.picListt);
            head=itemView.findViewById(R.id.head);
            header=itemView.findViewById(R.id.explanationn);

        }
    }


}

