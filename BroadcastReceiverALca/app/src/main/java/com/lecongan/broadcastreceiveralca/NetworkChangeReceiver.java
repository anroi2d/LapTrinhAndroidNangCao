package com.lecongan.broadcastreceiveralca;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Admin on 17/03/2018.
 */

public class NetworkChangeReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(MainActivity.ACTION_LCA)){
            String title = intent.getStringExtra(MainActivity.ACTION_LCA);
            Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
        }

    }
}
