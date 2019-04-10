package com.example.xue.myrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xue.myrecycleview.Adapter.MyAdapter;
import com.example.xue.myrecycleview.bean.news;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        RecyclerView recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        //设置布局
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setHasFixedSize(true);

        ArrayList<news> newsArrayList = new ArrayList<>();
        news news ;
        //数据准备
        for (int i = 0; i<= 99 ;i++ ){
            news = new news();
            news.setNewsTitle("中国2020年基本达到发达国家水准"+i);
            news.setNewsSource("人民网"+i);
            news.setPublishTime("2020-01-01");
            newsArrayList.add(news);
        }
        MyAdapter myAdapter = new MyAdapter(newsArrayList);
        recycler_view.setAdapter(myAdapter);
    }
}
