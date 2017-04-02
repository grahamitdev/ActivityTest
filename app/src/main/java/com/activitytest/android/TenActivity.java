package com.activitytest.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TenActivity extends BaseActivity {

    public static void actionStart(Context context, String data1, String data2){
        Intent intent=new Intent(context,TenActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);

        Intent intent=getIntent();
        String param1=intent.getStringExtra("param1");
        String param2=intent.getStringExtra("param2");
        Toast.makeText(TenActivity.this,param1+param2,Toast.LENGTH_SHORT).show();


    }
}
