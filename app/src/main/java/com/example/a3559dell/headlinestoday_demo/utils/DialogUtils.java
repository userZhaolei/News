package com.example.a3559dell.headlinestoday_demo.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.a3559dell.headlinestoday_demo.R;

/**
 * Created by 3559dell on 2017/7/21.
 */
public class DialogUtils {

    private static AlertDialog alertDialog;
    private static SharedPreferences sp;

    public static void CreateDialog(final Activity context){
        sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        View view =  LayoutInflater.from(context).inflate(R.layout.activity_dialog, null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.popver);
        Button diglog_btn = (Button) view.findViewById(R.id.dialog_btn);
        diglog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean key = sp.getBoolean("key", false);
                if(key){
                    imageView.setImageResource(R.drawable.daymode_popover_night);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sp.edit().putBoolean("key",false).commit();
                }else{
                    imageView.setImageResource(R.drawable.daymode_popover);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sp.edit().putBoolean("key",true).commit();
                }
                context.recreate();
            }
        });
       AlertDialog.Builder  dialog = new AlertDialog.Builder(context);
        alertDialog = dialog.create();
        alertDialog.show();

        Window window=alertDialog.getWindow();//获取当前的Window对象，然后下面进行窗口属性的设置
        window.setContentView(view);//加载布局，view是填充自定义菜单布局xml 得到的
        window.setBackgroundDrawableResource(android.R.color.transparent);//这个很重要，将背景设为透明
        // 这样子 第二和第三个按钮的空隙才会显示出来
        window.setGravity(Gravity.BOTTOM);//这个也很重要，将弹出菜单的位置设置为底部
        window.setWindowAnimations(R.style.animation_bottom_menu);//菜单进入和退出屏幕的动画，实现了上下滑动的动画效果
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置菜单的尺寸
    }
}
