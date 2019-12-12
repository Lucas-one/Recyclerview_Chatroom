package com.example.recyclerview_test;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;



public class ChatMessageViewHolder extends RecyclerView.ViewHolder {
    TextView content;
    TextView name;
    ImageView image;

    ChatMessageViewHolder(View itemView)
    {
        super(itemView);

        content = itemView.findViewById(R.id.content);
        name = itemView.findViewById(R.id.name);
        image = itemView.findViewById(R.id.chatmessage_iv_profile);
    }
}


