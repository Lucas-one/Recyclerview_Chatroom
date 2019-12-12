package com.example.recyclerview_test;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatMessageViewHolder2 extends RecyclerView.ViewHolder{

    TextView content;
    TextView name;
    ImageView image;

    ChatMessageViewHolder2(View itemView)
    {
        super(itemView);

        content = itemView.findViewById(R.id.content);
       // name = itemView.findViewById(R.id.name);
        //image = itemView.findViewById(R.id.imageView);
    }
}

