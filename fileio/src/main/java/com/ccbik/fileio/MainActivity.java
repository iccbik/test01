package com.ccbik.fileio;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FileOutputStream fos;
    FileInputStream fis;
    String filename = "hello.txt";
    TextView textView;
    private MyHelper myHelper;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String content = "我的世界";
//        try {
//            fos = openFileOutput(filename, MODE_PRIVATE);
//            fos.write(content.getBytes());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String readFile = "";
//        try {
//            fis = openFileInput(filename);
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            readFile = new String(buffer);
//            textView = findViewById(R.id.tv);
//            Toast.makeText(this, readFile, Toast.LENGTH_LONG).show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        myHelper = new MyHelper(this);
        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:

                db = myHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","hua");
                values.put("price",100);
                db.insert("info", null, values);
                Toast.makeText(this,"插入成功",Toast.LENGTH_LONG).show();
                db.close();
                break;
            case R.id.bt2:
                db = myHelper.getWritableDatabase();
                Cursor cursor = db.query("info", null, null, null, null, null, null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(this,"表中没有数据",Toast.LENGTH_LONG).show();
                }else{
                    cursor.moveToFirst();
                    Toast.makeText(this,cursor.getString(1)+":"+cursor.getString(2),Toast.LENGTH_LONG).show();
                    Log.d(TAG, cursor.getString(1)+":"+cursor.getString(2));

                    while(cursor.moveToNext()){
                        Toast.makeText(this,cursor.getString(1)+":"+cursor.getString(2),Toast.LENGTH_LONG).show();
                        Log.d(TAG, cursor.getString(1)+":"+cursor.getString(2));
                    }
                }
                cursor.close();
                db.close();
                break;
            case R.id.bt3:
                db = myHelper.getWritableDatabase();
                String name  = "hua";
                db.delete("info", "name=?", new String[]{name});
                db.close();
                Toast.makeText(this,"删除成功",Toast.LENGTH_LONG).show();
                break;
            case R.id.bt4:
                db = myHelper.getWritableDatabase();
                String name1  = "hua";
                ContentValues values1 = new ContentValues();
                values1.put("price", 200);
                db.update("info", values1, "name=?", new String[]{name1});
                db.close();
                Toast.makeText(this,"修改成功",Toast.LENGTH_LONG).show();
                break;

        }
    }
}