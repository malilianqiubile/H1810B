package com.example.day04diertao.molder;

import android.util.Log;

import com.example.day04diertao.bean.FzBean;
import com.example.day04diertao.bean.Lei;
import com.example.day04diertao.callback.CcallBack;

import javax.security.auth.callback.Callback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 小乐乐 on 2019/5/30.
 */

public class Imolder implements Molder {


    @Override
    public void getData(final CcallBack ccallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Lei.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Lei lei = retrofit.create(Lei.class);
        lei.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FzBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FzBean fzBean) {
                            if (fzBean!=null){
                                ccallBack.Scuess(fzBean);
                            }
                            else {
                                ccallBack.Error("请求失败");
                            }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag", "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
