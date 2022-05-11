package com.ccbik.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] strings = {"项目1","项目1",
            "项目1",
            "项目1",
            "项目1",
            "项目1","项目1",
            "项目1",
            "项目1","项目1","项目1","项目1","项目1","项目1",
            "项目1","项目1","项目1","项目1","项目1","项目1",
            "项目1","项目1","项目1","项目1","项目1","项目1",
            "项目1","项目1","项目1","项目1","项目1","项目1",
            "项目1","项目1","项目1","项目1","项目1","项目1",
    };
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv);
//        BaseAdapter adapter = new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return 40;
//            }
//
//            @Override
//            public Object getItem(int i) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int i) {
//                return i;
//            }
//
//            @Override
//            public View getView(int i, View view, ViewGroup viewGroup) {
//                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
//                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//                ImageView imageView = new ImageView(MainActivity.this);
//                imageView.setImageResource(R.drawable.ic_launcher_background);
//                TextView textView = new TextView(MainActivity.this);
//                textView.setText("第"+(i+1)+"个列表项");
//                textView.setTextSize(26);
//                textView.setTextColor(Color.RED);
//                linearLayout.addView(imageView);
//                linearLayout.addView(textView);
//                return linearLayout;
//            }
//        };
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(MainActivity.this, R.layout.itme_layout, null);
            TextView tv_books = view.findViewById(R.id.tv_book);
            ImageView imageView = view.findViewById(R.id.idbook);
            imageView.setImageResource(R.drawable.m);
            tv_books.setText(strings[i]);
            return view;
        }
    }
}
