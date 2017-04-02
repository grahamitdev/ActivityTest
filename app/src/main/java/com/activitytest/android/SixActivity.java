package com.activitytest.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SixActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Toast.makeText(SixActivity.this,data,Toast.LENGTH_SHORT).show();


        Button buttonreturn=(Button)findViewById(R.id.buttonreturn);
        buttonreturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.putExtra("data_return","return hello");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent();
        intent.putExtra("data_return","return Hello");
        setResult(RESULT_OK,intent);
        finish();
    }
}
