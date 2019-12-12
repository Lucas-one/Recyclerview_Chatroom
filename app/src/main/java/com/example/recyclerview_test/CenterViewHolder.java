package com.example.recyclerview_test;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CenterViewHolder extends RecyclerView.ViewHolder {

    TextView content;

    CenterViewHolder(View itemView)
    {
        super(itemView);

        content = itemView.findViewById(R.id.content);
    }
}

