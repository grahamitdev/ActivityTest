package com.activitytest.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by gzyit on 2017/03/31.
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_SHORT).show();
    }
}
