package com.example.android.devcheck;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.devcheck.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private List<CardItems> cardItemsList;

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    public MyAdapter(List<CardItems> cardItemsList, Context context) {

        this.cardItemsList = cardItemsList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_items, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final CardItems cardItems = cardItemsList.get(position);

        holder.username.setText(cardItems.getUserName());

        Picasso.get()
                .load(cardItems.getImageUrl())
                .into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardItems cardItems1 = cardItemsList.get(position);

                Intent profileIntent = new Intent(v.getContext(), ProfileActivity.class);

                profileIntent.putExtra(KEY_NAME, cardItems1.getUserName());
                profileIntent.putExtra(KEY_URL, cardItems1.getDevUrl());
                profileIntent.putExtra(KEY_IMAGE, cardItems1.getImageUrl());

                v.getContext().startActivity(profileIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView imageView;
        public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            imageView = itemView.findViewById(R.id.picture);
            html_url = itemView.findViewById(R.id.developerUrl);
            linearLayout = itemView.findViewById(R.id.card_linear_layout);
        }
    }
}
