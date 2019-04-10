package com.example.xue.myrecycleview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xue.myrecycleview.R;
import com.example.xue.myrecycleview.bean.news;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private static final int HEADHOLDER = 0;
    private static final int NEWSHOLDER = 1;
    List<news> arrayList;

    public MyAdapter(ArrayList<news> arrayList){
        this.arrayList=arrayList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if (viewType == HEADHOLDER) {
            View headView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_nhead,null);
            MyHeadHolder myHeadHolder = new MyHeadHolder(headView);
            return myHeadHolder;
        } else if (viewType == NEWSHOLDER){
            View newsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_news,null);
            MyNewsHolder myNewsHolder = new MyNewsHolder(newsView);
            return  myNewsHolder;
        }else {
            View endView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_end,null);
            MyEndHolder myEndHolder = new MyEndHolder(endView);
            return myEndHolder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHeadHolder) {
            MyHeadHolder headHolder = (MyHeadHolder) holder;
            headHolder.im_head.setScaleType(ImageView.ScaleType.CENTER);
        } else if (holder instanceof MyNewsHolder){
            news news = arrayList.get(position - 1);
            MyNewsHolder newsHolder = (MyNewsHolder) holder;
            newsHolder.tv_title.setText(news.getNewsTitle());
            newsHolder.tv_source.setText(news.getNewsSource());
            newsHolder.tv_publishtime.setText(news.getPublishTime());

        }else {
            MyEndHolder endHolder = (MyEndHolder) holder;
            endHolder.tv_end.setText("拉到底了兄弟，没有内容了");

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size()==0?2:arrayList.size()+2;
    }

    public static class MyHeadHolder extends RecyclerView.ViewHolder {
        ImageView im_head;
        public MyHeadHolder(@NonNull View itemView) {
            super(itemView);
            im_head = (ImageView)itemView.findViewById(R.id.news_image);
        }
    }

    public static class MyNewsHolder extends RecyclerView.ViewHolder {

        TextView tv_title;
        TextView tv_source;
        TextView tv_publishtime;
        public MyNewsHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_source = (TextView) itemView.findViewById(R.id.tv_source);
            tv_publishtime = (TextView) itemView.findViewById(R.id.tv_publishtime);

        }
    }
    public static class  MyEndHolder extends RecyclerView.ViewHolder {
        TextView tv_end;

        public MyEndHolder(@NonNull View itemView) {
            super(itemView);
             tv_end = (TextView)itemView.findViewById(R.id.tv_end);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (HEADHOLDER == position) {
            return 0;
       /* } else if (arrayList.size()>=position) {*/
        } else if (arrayList.size()+2 == position) {
            return -1;
        }else {
            return 1;
        }
    }
}
