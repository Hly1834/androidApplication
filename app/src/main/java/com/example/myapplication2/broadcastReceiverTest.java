package com.example.myapplication2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class broadcastReceiverTest extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        //取出intent中相关参数
        String actionStr = intent.getStringExtra("intentTest");
        Toast.makeText(context,actionStr,Toast.LENGTH_LONG).show();
    }
}
