package com.lecongan.broadcastreceiveralca;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    NetworkChangeReceiver networkChangeReceiver;
    public static final String ACTION_LCA = "lecongan.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, CustomActivity.class);
//                startActivity(intent);
//                finish();
                Intent intent = new Intent();
                intent.putExtra(ACTION_LCA, "Search Everything! Ok");
                intent.setAction(ACTION_LCA);
                sendBroadcast(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initBroadcastReceive();
    }

    private void initBroadcastReceive() {
        networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //// TODO: 17/03/2018
//        unregisterReceiver(networkChangeReceiver);
        //neu huy MainActitity thi phai huy broadcast
        //neu khong se sinh ra loi
    }
}
