package com.activitytest.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThirdActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());//杀掉当前进程
    }
}
