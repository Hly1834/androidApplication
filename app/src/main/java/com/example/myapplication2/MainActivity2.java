package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button button1=findViewById(R.id.button);
        button1.setOnClickListener((v)->{
            Toast.makeText(getApplicationContext(),"即将跳转",Toast.LENGTH_LONG).show();
            Uri url=Uri.parse("http://www.baidu.com");
            //intent 获取页面  startActivity 跳转activity
            Intent intent =new  Intent(Intent.ACTION_VIEW,url);

            startActivity(intent);

        });
    }
}