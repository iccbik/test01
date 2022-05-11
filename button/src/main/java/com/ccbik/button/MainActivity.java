package com.ccbik.button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Button bt1;
    private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btoText);
        bt1 = findViewById(R.id.bto1);
        bt2 = findViewById(R.id.bto2);
        button.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("普通对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("是否确定退出应用程序");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    public void edit(View view) {
        Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btoText:
                Intent intent1 = new Intent(this, ButtonActivity.class);
                startActivity(intent1);
                break;
            case R.id.bto1:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
            case R.id.bto2:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                break;
        }
    }
}