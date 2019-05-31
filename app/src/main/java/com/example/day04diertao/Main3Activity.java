package com.example.day04diertao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.day04diertao.adapter.AdapterEr;
import com.example.day04diertao.adapter.AdapterSan;
import com.example.day04diertao.bean.SjBean;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView mRvvv;
    private ArrayList<SjBean> mSjBeans;
    private AdapterSan mAdapterSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mRvvv = (RecyclerView) findViewById(R.id.rvvv);

        LinearLayoutManager manager = new LinearLayoutManager(Main3Activity.this);
        mRvvv.setLayoutManager(manager);
        mSjBeans = new ArrayList<>();
        mAdapterSan = new AdapterSan(mSjBeans, Main3Activity.this);
        mRvvv.setAdapter(mAdapterSan);

        List<SjBean> sjBeans = new DaoMapp().selectAll();
        mSjBeans.addAll(sjBeans);
        mAdapterSan.notifyDataSetChanged();
    }
}
