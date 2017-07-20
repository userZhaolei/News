package com.example.a3559dell.headlinestoday_demo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3559dell.headlinestoday_demo.Adapter.MyAdapter;
import com.example.a3559dell.headlinestoday_demo.R;
import com.example.a3559dell.headlinestoday_demo.mobel.MyBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.XListView;

/**
 * Created by 3559dell on 2017/7/7.
 */
public class ContentFragment extends Fragment {

    private List<MyBean.ListBean> list;
    private MyAdapter adapter;
    private String  path;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
        }
    };
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
        XListView xlv = (XListView) view.findViewById(R.id.xListView);
        list = new ArrayList<>();
        adapter = new MyAdapter(list,getActivity(), R.layout.activity_fragment_item);
        xlv.setAdapter(adapter);
    }

    public void getHttpUrl() {
        OkHttpClient mOkHttpClient = new OkHttpClient();
         Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
           @Override
           public void onFailure(Request request, IOException e) {
               
           }

           @Override
           public void onResponse(Response response) throws IOException {
               MyBean myBean = new Gson().fromJson(response.body().string(), MyBean.class);
               list.addAll(myBean.getList());
               handler.sendEmptyMessage(1);
           }
       });

    }
}
