package com.example.recyclerview_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ChatMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataItem> myDataList = null;
    ChatMessageAdapter(ArrayList<DataItem> dataList)
    {
        myDataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(viewType == Code.ViewType.CENTER_CONTENT)
        {
            view = inflater.inflate(R.layout.center_content, parent, false);
            return new CenterViewHolder(view);
        }
        else if(viewType == Code.ViewType.LEFT_CONTENT)
        {
            view = inflater.inflate(R.layout.item_chatmessage, parent, false);
            return new ChatMessageViewHolder(view);
        }
        else
        {
            view = inflater.inflate(R.layout.item_chatmessage2, parent, false);
            return new ChatMessageViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if(viewHolder instanceof CenterViewHolder)
        {
            ((CenterViewHolder) viewHolder).content.setText(myDataList.get(position).getContent());
        }
        else if(viewHolder instanceof ChatMessageViewHolder)
        {
            ((ChatMessageViewHolder) viewHolder).name.setText(myDataList.get(position).getName());
            ((ChatMessageViewHolder) viewHolder).content.setText(myDataList.get(position).getContent());
        }
        else
        {
           // ((ChatMessageViewHolder2) viewHolder).name.setText(myDataList.get(position).getName());
            ((ChatMessageViewHolder2) viewHolder).content.setText(myDataList.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return myDataList.get(position).getViewType();
    }




}