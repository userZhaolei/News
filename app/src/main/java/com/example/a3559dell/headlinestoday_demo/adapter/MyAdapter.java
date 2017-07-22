package com.example.a3559dell.headlinestoday_demo.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a3559dell.headlinestoday_demo.R;
import com.example.a3559dell.headlinestoday_demo.mobel.MyBean;

import java.util.List;

/**
 * Created by 3559dell on 2017/7/20.
 */
public class MyAdapter extends BaseAdapter {
    private List<MyBean.ListBean> list;
    private Context context;
    private int item;

    public MyAdapter(List<MyBean.ListBean> list, Context context, int item) {
        this.list = list;
        this.context = context;
        this.item = item;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, item, null);
            viewHolder = new ViewHolder();
            viewHolder.time = (TextView) convertView.findViewById(R.id.item_time);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(list.get(position).getTitle());
        viewHolder.time.setText(list.get(position).getTime());
        Glide.with(context).load(list.get(position).getImgurl()).into(viewHolder.image);
        return convertView;
    }

    class ViewHolder {
        TextView title, time;
        ImageView image;
    }
}
