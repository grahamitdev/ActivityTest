package com.activitytest.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifeActivity extends BaseActivity  {
    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_life);
        //如果活动被收回了
        if(savedInstanceState!=null){
            String tempData=savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
            //Toast.makeText(LifeActivity.this, "活动被收回了", Toast.LENGTH_SHORT).show();
        }




        Button normal=(Button)findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LifeActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        Button dialog=(Button)findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LifeActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
        Button newactivity=(Button)findViewById(R.id.newactivity);
        newactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LifeActivity.this,LifeActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected  void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
    //活动被收回了怎么办
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String tempData="Something you just typed";
        outState.putString("data_key",tempData);
    }









}
