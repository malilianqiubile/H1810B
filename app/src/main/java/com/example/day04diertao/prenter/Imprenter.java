package com.example.day04diertao.prenter;

import android.util.Log;

import com.example.day04diertao.bean.FzBean;
import com.example.day04diertao.callback.CcallBack;
import com.example.day04diertao.molder.Imolder;
import com.example.day04diertao.mview.Mview;

/**
 * Created by 小乐乐 on 2019/5/30.
 */

public class Imprenter implements Prenter, CcallBack {
    private Imolder mImoder;
    private Mview mMview;

    public Imprenter(Imolder imoder, Mview mview) {
        mImoder = imoder;
        mMview = mview;
    }

    @Override
    public void getData() {
        if (mImoder!=null){
            mImoder.getData(this);
        }
    }

    @Override
    public void Scuess(FzBean fzBean) {
            if (mMview!=null){
                mMview.Scuess(fzBean);
            }
            else {
                mMview.Error("请求失败");
            }
    }

    @Override
    public void Error(String error) {
        Log.e("tag", "Error: "+error );
    }
}
