package com.example.day04diertao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 小乐乐 on 2019/5/30.
 */
@Entity
public class SjBean {
@Id(autoincrement = true)
    private Long id;
    private String title;
    private String pic;
    private String food_str;
    @Generated(hash = 312276325)
    public SjBean(Long id, String title, String pic, String food_str) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.food_str = food_str;
    }
    @Generated(hash = 1815906733)
    public SjBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getFood_str() {
        return this.food_str;
    }
    public void setFood_str(String food_str) {
        this.food_str = food_str;
    }
    
}
