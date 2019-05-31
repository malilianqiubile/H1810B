package com.example.day04diertao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day04diertao.R;
import com.example.day04diertao.bean.SjBean;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/5/30.
 */

public class AdapterSan extends RecyclerView.Adapter<AdapterSan.ViewHolder> {
    private ArrayList<SjBean> mList;
    private Context context;

    public AdapterSan(ArrayList<SjBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yixml, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getPic()).into(holder.mIvPic);
        holder.mTvTitle.setText(mList.get(position).getTitle());
            holder.mTvFoodStr.setText(mList.get(position).getFood_str());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvPic;
        TextView mTvFoodStr;
        TextView mTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            this.mIvPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            this.mTvFoodStr = (TextView) itemView.findViewById(R.id.tv_food_str);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


}
