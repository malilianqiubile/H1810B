package com.example.day04diertao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.day04diertao.adapter.AdapterRe;
import com.example.day04diertao.bean.FzBean;
import com.example.day04diertao.molder.Imolder;
import com.example.day04diertao.mview.Mview;
import com.example.day04diertao.prenter.Imprenter;

import java.util.ArrayList;
import java.util.List;

//惠微乐
public class MainActivity extends AppCompatActivity implements Mview {

    private RecyclerView mRev;
    private Imprenter mImprenter;
    private ArrayList<FzBean.DataBean> mList;
    private AdapterRe mAdapterRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImprenter = new Imprenter(new Imolder(), this);
        mImprenter.getData();
        initView();
    }

    private void initView() {
        mRev = (RecyclerView) findViewById(R.id.rev);

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mRev.setLayoutManager(manager);
        mList = new ArrayList<>();
        mAdapterRe = new AdapterRe(mList, this);
        mRev.setAdapter(mAdapterRe);


        mAdapterRe.setOnLongClickListener(new AdapterRe.OnLongClickListener() {
            @Override
            public void OnLongClickListener(int position) {
               // FzBean.DataBean dataBean = mList.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Scuess(FzBean fzBean) {
        List<FzBean.DataBean> data = fzBean.getData();
        mList.addAll(data);
        mAdapterRe.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {
        Log.e("tag", "Error: "+error );
    }
}
