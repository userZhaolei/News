package com.example.a3559dell.headlinestoday_demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.a3559dell.headlinestoday_demo.Adapter.MyAdapter;
import com.example.a3559dell.headlinestoday_demo.R;
import com.example.a3559dell.headlinestoday_demo.activity.ShowWebActivity;
import com.example.a3559dell.headlinestoday_demo.mobel.MyBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.maxwin.view.XListView;

/**
 * Created by 3559dell on 2017/7/7.
 */
public class ContentFragment extends Fragment implements XListView.IXListViewListener{

    private List<MyBean.ListBean> list;
    private MyAdapter adapter;
    private String  path;
    private int index=1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            list.addAll(((MyBean)msg.obj).getList());
            adapter.notifyDataSetChanged();
        }
    };
    private XListView xlv;

    public ContentFragment(String path) {
        this.path = path;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_content_fragment,null);
        initView(view);
        getHttpUrl();
        return view;
    }

    private void initView(View view) {
        xlv = (XListView) view.findViewById(R.id.xListView);
        list = new ArrayList<>();
        adapter = new MyAdapter(list,getActivity(), R.layout.activity_fragment_item);
        xlv.setAdapter(adapter);
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        xlv.setXListViewListener(this);
        xlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               MyBean.ListBean bean= (MyBean.ListBean) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), ShowWebActivity.class);
                intent.putExtra("url",bean.getDocurl());
                startActivity(intent);
            }
        });
    }

    public void getHttpUrl() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
         Request request = new Request.Builder()
                .url(path+index)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
           @Override
           public void onFailure(Request request, IOException e) {

           }

           @Override
           public void onResponse(Response response) throws IOException {
             /*  Log.e("----------------------",response.body().string().toString()+Thread.currentThread().getName());*/
               MyBean myBean = new Gson().fromJson(response.body().string(), MyBean.class);
               Message msg = handler.obtainMessage();
               msg.obj = myBean;
               handler.sendMessage(msg);
           }
       });
    }

    @Override
    public void onRefresh() {
        list.clear();
        index = 1;
        getHttpUrl();
        load();
    }

    private void load() {
        xlv.stopRefresh();
        xlv.stopLoadMore();
        xlv.setRefreshTime(stampToDate());
    }

    @Override
    public void onLoadMore() {
        index++;
        getHttpUrl();
        load();
    }
    public String stampToDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String res = simpleDateFormat.format(date);
        return res;
    }
}
