package com.example.recyclerview_test;

public class DataItem {

    private String content;
    private String name;
    private int viewType;   //Viewtype 내가 보낸건지 다른 사람이 보낸건지 check

    public DataItem(String content, String name, int viewType){
        this.content = content;
        this.name = name;
        this.viewType = viewType;
    }

    public String getContent(){
        return content;
    }
    public String getName(){
        return name;
    }

    public int getViewType(){
        return viewType;
    }
}



