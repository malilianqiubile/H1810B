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
import com.bumptech.glide.request.RequestOptions;
import com.example.day04diertao.R;
import com.example.day04diertao.bean.FzBean;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/5/30.
 */

public class AdapterRe extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<FzBean.DataBean> mList;
    private Context context;

    public AdapterRe(ArrayList<FzBean.DataBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.yixml, parent, false);
                return new holder1(inflate1);

            case 2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.erxml, parent, false);
                return new holder2(inflate2);

            case 3:
                View inflate3 = LayoutInflater.from(context).inflate(R.layout.sanxml, parent, false);
                return new holder3(inflate3);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof holder1) {
            holder1 holder1 = (AdapterRe.holder1) holder;
            RequestOptions requestOptions = RequestOptions.circleCropTransform().circleCrop();
            Glide.with(context).load(mList.get(position).getPic()).into(holder1.mIvPic);
            holder1.mTvFoodStr.setText(mList.get(position).getFood_str());
            holder1.mTvTitle.setText(mList.get(position).getTitle());
        } else if (holder instanceof holder2) {
            holder2 holder2 = (AdapterRe.holder2) holder;
            RequestOptions requestOptions = RequestOptions.circleCropTransform().circleCrop();
            Glide.with(context).load(mList.get(position).getPic()).into(holder2.mIvPic2);
            holder2.mTvTitle2.setText(mList.get(position).getTitle());

        } else {
            holder3 holder3= (holder3) holder;
            RequestOptions requestOptions = RequestOptions.circleCropTransform().circleCrop();
            Glide.with(context).load(mList.get(position).getPic()).into(holder3.mIvTu1);
            Glide.with(context).load(mList.get(position).getPic()).into(holder3.mIvTu2);
            holder3.mZi1.setText(mList.get(position).getTitle());
            holder3.mTvZi2.setText(mList.get(position).getTitle());

        }


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (OnLongClickListener!=null){
                    OnLongClickListener.OnLongClickListener(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    class holder1 extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvPic;
        TextView mTvFoodStr;
        TextView mTvTitle;

        public holder1(View itemView) {
            super(itemView);
            view = itemView;
            this.mIvPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            this.mTvFoodStr = (TextView) itemView.findViewById(R.id.tv_food_str);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    class holder2 extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvPic2;
        TextView mTvTitle2;

        public holder2(View itemView) {
            super(itemView);
            view = itemView;
            this.mIvPic2 = (ImageView) itemView.findViewById(R.id.iv_pic2);
            this.mTvTitle2 = (TextView) itemView.findViewById(R.id.tv_title2);
        }
    }



    class holder3 extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvTu1;
        TextView mZi1;
        ImageView mIvTu2;
        TextView mTvZi2;

        public holder3(View itemView) {
            super(itemView);
            view = itemView;
            this.mIvTu1 = (ImageView) itemView.findViewById(R.id.iv_tu1);
            this.mZi1 = (TextView) itemView.findViewById(R.id.zi1);
            this.mIvTu2 = (ImageView) itemView.findViewById(R.id.iv_tu2);
            this.mTvZi2 = (TextView) view.findViewById(R.id.tv_zi2);
        }
    }
    public interface OnLongClickListener{
        void  OnLongClickListener(int position);
    }
    private OnLongClickListener OnLongClickListener;

    public void setOnLongClickListener(AdapterRe.OnLongClickListener onLongClickListener) {
        OnLongClickListener = onLongClickListener;
    }
}
