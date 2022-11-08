package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.flatbuffers.Constants;

public class MainActivity extends AppCompatActivity {
    private TextView textView2;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat
                            .format("yyyy/M/dd hh:mm", sysTime);
                    textView2.setText("当前时间:"+sysTimeStr);
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView2=findViewById(R.id.textView2);
//        Log.d("mainMessage","START SUCCESS");
//        System.out.println("another one");
        buttonListener();
//        dynamicTime();
        new Thread() {
            public void run() {
                while(true) { //保证线程一直执行
                    try {

                        //给Handler发送信息
                        mHandler.sendEmptyMessage(1);
                        //休眠1秒
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
    }


    public void buttonListener(){
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        //button 监听事件
        button1.setOnClickListener((v)->{
            Toast.makeText(getApplicationContext(),"即将跳转",Toast.LENGTH_LONG).show();

            //intent 获取页面  startActivity 跳转activity
            Intent intent =new  Intent(this, MainActivity2.class);
            startActivity(intent);

        });
        button2.setOnClickListener((v)->{

            //自定义广播并使用intent传递参数
            Intent intent=new Intent().setAction("com.example.myapplication2.MY_BROADCAST");
            intent.setPackage(getPackageName());
            //intent存储自定义参数并传递
            intent.putExtra("intentTest","这是一条模拟广播(intent传递数据)");
            sendBroadcast(intent);

        });
    }


    //创建时默认菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.addremove,menu);


        return true;
    }

    //默认菜单选项监听事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.add_item:
                Toast.makeText(getApplicationContext(),"checked add",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(getApplicationContext(),"checked remove",Toast.LENGTH_LONG).show();
                break;

            default:
                break;

        }
        return true;
    }
}