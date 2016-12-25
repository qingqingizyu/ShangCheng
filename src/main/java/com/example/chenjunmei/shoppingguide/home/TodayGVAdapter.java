package com.example.chenjunmei.shoppingguide.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chenjunmei.shoppingguide.R;
import com.example.chenjunmei.shoppingguide.bean.WomenBean;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by ChenJunMei on 2016/11/25.
 */

public class TodayGVAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<WomenBean.WomenData.ModuleBean.DataBean> module1data;

    public TodayGVAdapter(Context mContext, List<WomenBean.WomenData.ModuleBean.DataBean> module1data) {
        this.mContext = mContext;
        this.module1data = module1data;
    }

    @Override
    public int getCount() {
        return module1data == null ? 0 : module1data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            //item的布局：垂直线性，ImagView+TextView
            convertView = View.inflate(mContext, R.layout.item_channel, null);
            holder = new ViewHolder();
            holder.iv_channel = (ImageView) convertView.findViewById(R.id.iv_channel);
            holder.tv_channel = (TextView) convertView.findViewById(R.id.tv_channel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //装配数据
        WomenBean.WomenData.ModuleBean.DataBean datasig = module1data.get(position);

        //使用Glide加载图片
        Glide.with(mContext).load(datasig.getImg()).into(holder.iv_channel);
        //设置文本
        holder.tv_channel.setText(datasig.getTitle());

        return convertView;
    }

    public static class ViewHolder {
        public ImageView iv_channel;
        public TextView tv_channel;
    }
}
