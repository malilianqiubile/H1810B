package com.example.day04diertao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.day04diertao.adapter.AdapterEr;
import com.example.day04diertao.adapter.AdapterRe;
import com.example.day04diertao.bean.FzBean;
import com.example.day04diertao.bean.SjBean;
import com.example.day04diertao.molder.Imolder;
import com.example.day04diertao.mview.Mview;
import com.example.day04diertao.prenter.Imprenter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements Mview {

    private RecyclerView mRev2;
    private ArrayList<FzBean.DataBean> mList;
    private AdapterEr mAdapterEr;
    private Imprenter mImprenter;
    public int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mImprenter = new Imprenter(new Imolder(), this);
        mImprenter.getData();
        initView();
    }

    private void initView() {
        mRev2 = (RecyclerView) findViewById(R.id.rev2);
        registerForContextMenu(mRev2);
        LinearLayoutManager manager = new LinearLayoutManager(Main2Activity.this);
        mRev2.setLayoutManager(manager);
        mList = new ArrayList<>();

        mAdapterEr = new AdapterEr(mList, Main2Activity.this);
        mRev2.setAdapter(mAdapterEr);
        mAdapterEr.setOnLongClickListener(new AdapterEr.OnLongClickListener() {
            @Override
            public void OnLongClickListener(int position) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        mAdapterEr.setOnClickListener(new AdapterEr.OnClickListener() {

            @Override
            public void OnClickListener(int position) {
                a=position;

            }
        });

    }


    @Override
    public void Scuess(FzBean fzBean) {
        List<FzBean.DataBean> data = fzBean.getData();
        mList.addAll(data);
        mAdapterEr.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {
        Log.e("tag", "Error: "+error );
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1,1,1,"收藏");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:

                SjBean sjBean = new SjBean();
                sjBean.setFood_str(mList.get(a).getFood_str());
                sjBean.setTitle(mList.get(a).getTitle());
                sjBean.setPic(mList.get(a).getPic());
                new DaoMapp().getDaoMapp().insertItem(sjBean);

                Toast.makeText(Main2Activity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
