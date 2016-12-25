package com.example.chenjunmei.shoppingguide.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.chenjunmei.shoppingguide.R;
import com.example.chenjunmei.shoppingguide.bean.WomenBean;

import java.util.List;

/**
 * Created by ChenJunMei on 2016/11/25.
 */

public class DaPeiQSRecycleViewAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final List<WomenBean.WomenData.ModuleBean.DataBean> dapeiqs6data;

    public DaPeiQSRecycleViewAdapter(Context mContext, List<WomenBean.WomenData.ModuleBean.DataBean> dapeiqs6data) {
        this.mContext = mContext;
        this.dapeiqs6data = dapeiqs6data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_dapeiqs, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return dapeiqs6data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_figure;


        public MyViewHolder(View itemView) {
            super(itemView);
            iv_figure = (ImageView) itemView.findViewById(R.id.iv_figure);
        }

        public void setData(int position) {
            WomenBean.WomenData.ModuleBean.DataBean dapeiBean = dapeiqs6data.get(position);
            //使用Glide加载图片
            Glide.with(mContext)
                    .load(dapeiBean.getImg())
                    .into(iv_figure);
        }
    }
}
