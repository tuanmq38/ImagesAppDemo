package com.example.imagesappdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Item> itemList;

    public RecyclerAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.setImageView(item.getImageUrl());
        holder.setmTags(item.getTags());
        holder.setmLikes(item.getLikes());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mTags, mLikes;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
        public void setImageView(String url) {
            imageView = view.findViewById(R.id.imageView);
            Glide.with(context).load(url).into(imageView);
        }

        public void setmLikes(int likes) {
            mLikes = view.findViewById(R.id.likes);
            mLikes.setText(likes + " Likes");
        }

        public void setmTags(String tag) {
            mTags = view.findViewById(R.id.tags);
            mTags.setText(tag);
        }
    }
}
