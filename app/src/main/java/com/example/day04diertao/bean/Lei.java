package com.example.day04diertao.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 小乐乐 on 2019/5/30.
 */

public interface Lei {
    String url="http://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FzBean> getData();
}
