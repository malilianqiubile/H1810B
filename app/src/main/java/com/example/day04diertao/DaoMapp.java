package com.example.day04diertao;

import android.app.Application;

import com.example.day04diertao.bean.SjBean;
import com.example.lizhengjun.dao.DaoMaster;
import com.example.lizhengjun.dao.DaoSession;
import com.example.lizhengjun.dao.SjBeanDao;

import java.util.List;

/**
 * Created by 小乐乐 on 2019/5/30.
 */

public class DaoMapp extends Application {
    private static DaoMapp mDaoMapp;
    private SjBeanDao mSjBeanDao1;

    public  DaoMapp getDaoMapp() {
        if (mDaoMapp == null) {
            synchronized (DaoMapp.class) {
                if (mDaoMapp == null) {
                    mDaoMapp = new DaoMapp();
                }
            }
        }
        return mDaoMapp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mDaoMapp=this;
        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(DaoMapp.mDaoMapp, "disitao.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mSjBeanDao1 = daoSession.getSjBeanDao();
    }


    //插入
    public void insertItem(SjBean sjBean) {
        mSjBeanDao1.insertOrReplaceInTx(sjBean);
    }

   /* //查询
    public List<SjBean> loadAll() {
        return mSjBeanDao1.loadAll();
    }*/

   public List<SjBean> selectAll(){
       DaoMapp daoMapp = DaoMapp.mDaoMapp.getDaoMapp();
       List<SjBean> sjBeans = daoMapp.selectAll();
       return sjBeans;
   }
}
