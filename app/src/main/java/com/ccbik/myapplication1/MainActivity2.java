package com.ccbik.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        TextView textView = new TextView(this);
        textView.setText("使用java代码实现布局文件");
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(30);

        relativeLayout.addView(textView,params);
        setContentView(relativeLayout);

    }
}